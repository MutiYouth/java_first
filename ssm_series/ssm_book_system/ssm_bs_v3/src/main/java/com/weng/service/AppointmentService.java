package com.weng.service;

import com.weng.bean.request.AppointmentRequest;
import com.weng.bean.entity.Appointment;


public interface AppointmentService {
  int appoint(AppointmentRequest record);
  int returnBook(Appointment record);
}
