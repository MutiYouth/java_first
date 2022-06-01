package com.weng.service.impl;

import com.weng.dao.BookDao;
import com.weng.bean.entity.Book;
import com.weng.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {

  @Autowired
  private BookDao bookDao;

  public Book getById(long bookId) {
    return bookDao.queryById(bookId);
  }

  public List<Book> getList(int start, int pageNum) {
    return bookDao.queryAll(start, pageNum);
  }

  public int addBook(Book book) {
    return bookDao.addBook(book);
  }

  public int updateBook(Book book) {
    return bookDao.updateBook(book);
  }

  public int deleteBookById(long id) {
    return bookDao.deleteBookById(id);
  }

  public int countNum() {
    return bookDao.countNum();
  }

  public List<Book> getListPlug() {
    return bookDao.queryAllPlug();
  }
}
