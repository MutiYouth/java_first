package com.weng.service.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import com.weng.dao.AppointmentDao;
import com.weng.dao.BookDao;
import com.weng.dao.form.AppointmentForm;
import com.weng.entity.Appointment;
import com.weng.entity.AppointmentExample;
import com.weng.entity.Book;
import com.weng.service.AppointmentService;
import java.util.List;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AppointmentServiceImpl implements AppointmentService {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private AppointmentDao appointmentMapper;
  @Autowired
  private BookDao bookDao;

  /**
   * 预约图书
   */
  //如果发生了异常，就进行回滚
  @Transactional(rollbackFor = {Exception.class})
  public int appoint(AppointmentForm record) {
    //利用google guava判空
    checkNotNull(record.getUserNumber(), "用户号不能为空");
    checkNotNull(record.getBookId(), "图书编号不能为空");
    //利用joda-time生成时间，并且计算时间
    DateTime dt = new DateTime();
    record.setAppointmentTime(dt.toDate());
    //预计持有时间
    int holdDay = Integer.valueOf(record.getHoldDay());
    //利用持有时间计算预计归还时间
    record.setExpectReturnTime(dt.plusDays(holdDay).toDate());
    Book book = bookDao.queryById(record.getBookId());
    int num = book.getNumber();
    int insert = 0;
    if (num >= 1) {
      insert = appointmentMapper.insert(record);
      book.setNumber(num - 1);
      logger.info("借书入参 AppointmentServiceImpl >>>>> " + record.toString());
      bookDao.updateBook(book);
//      checkNotNull(null, "出现异常，事物回滚。用来测试事物控制");
    }
    return insert;
  }

  /**
   * 归还图书
   */
  @Transactional(rollbackFor = {Exception.class})
  public int returnBook(Appointment record) {
    //利用google guava判空
    checkNotNull(record.getUserNumber(), "用户号不能为空");
    checkNotNull(record.getBookId(), "图书编号不能为空");
    //利用joda-time生成时间，并且计算时间
    DateTime dt = new DateTime();
    //查询是否存在已经借出的书籍
    AppointmentExample example = new AppointmentExample();
    example.createCriteria()
        .andBookIdEqualTo(Integer.valueOf(record.getBookId()))
        .andUserNumberEqualTo(Integer.valueOf(record.getUserNumber()));
    List<Appointment> appointments = appointmentMapper.selectByExample(example);

    logger.info("appointments >>>>> " + appointments.toString());
    logger.info("appointments size >>>>> " + appointments.size());
    logger.info("appointments status >>>>> " + appointments.get(0).getStatus());
    int i = 0;
    if (appointments.size() > 0) {
      Appointment appointment = appointments.get(0);
      if (0 == appointment.getStatus()) {
        appointment.setRealReturnTime(new DateTime().toDate());
        appointment.setStatus(1);
        logger.info("还书入参 AppointmentServiceImpl >>>>> " + appointment.toString());
        i = appointmentMapper.updateByPrimaryKey(appointment);
        logger.info("appointments i >>>>> " + i);
      }
    } else {
      logger.info("AppointmentServiceImpl 为进入更新状态 >>>>> " + i);
    }
    return i;
  }
}
