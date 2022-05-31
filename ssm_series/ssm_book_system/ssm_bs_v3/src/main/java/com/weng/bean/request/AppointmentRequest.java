package com.weng.bean.request;

import com.weng.bean.entity.Appointment;

/**
 * Created by weng on 17-8-27.
 * E-mail: hisenyuan@gmail.com
 */
public class AppointmentRequest extends Appointment{
  private String holdDay;

  public String getHoldDay() {
    return holdDay;
  }

  public void setHoldDay(String holdDay) {
    this.holdDay = holdDay;
  }

  @Override
  public String toString() {
    return "AppointmentRequest{" +
        "holdDay='" + holdDay + '\'' +
        '}';
  }
}