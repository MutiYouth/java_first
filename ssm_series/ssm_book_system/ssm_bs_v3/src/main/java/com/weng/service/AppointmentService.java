package com.weng.service;

import com.weng.bean.request.AppointmentRequest;
import com.weng.bean.entity.Appointment;

/**
 * Created by hisenyuan on 2017/8/2 at 10:36.
 */
public interface AppointmentService {
  int appoint(AppointmentRequest record);
  int returnBook(Appointment record);
}
