package com.weng.service;

import com.weng.dao.form.AppointmentForm;
import com.weng.entity.Appointment;


public interface AppointmentService {
  int appoint(AppointmentForm record);
  int returnBook(Appointment record);
}
