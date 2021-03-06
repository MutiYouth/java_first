package com.weng.entity;
import java.util.Date;


public class Appointment {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appointment.id
     *
     * @mbggenerated Thu Aug 03 16:47:27 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appointment.book_id
     *
     * @mbggenerated Thu Aug 03 16:47:27 CST 2017
     */
    private Integer bookId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appointment.user_number
     *
     * @mbggenerated Thu Aug 03 16:47:27 CST 2017
     */
    private Integer userNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appointment.appointment_time
     *
     * @mbggenerated Thu Aug 03 16:47:27 CST 2017
     */
    private Date appointmentTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appointment.expect_return_time
     *
     * @mbggenerated Thu Aug 03 16:47:27 CST 2017
     */
    private Date expectReturnTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appointment.real_return_time
     *
     * @mbggenerated Thu Aug 03 16:47:27 CST 2017
     */
    private Date realReturnTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appointment.status
     *
     * @mbggenerated Thu Aug 03 16:47:27 CST 2017
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column appointment.id
     *
     * @return the value of appointment.id
     *
     * @mbggenerated Thu Aug 03 16:47:27 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column appointment.id
     *
     * @param id the value for appointment.id
     *
     * @mbggenerated Thu Aug 03 16:47:27 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column appointment.book_id
     *
     * @return the value of appointment.book_id
     *
     * @mbggenerated Thu Aug 03 16:47:27 CST 2017
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column appointment.book_id
     *
     * @param bookId the value for appointment.book_id
     *
     * @mbggenerated Thu Aug 03 16:47:27 CST 2017
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column appointment.user_number
     *
     * @return the value of appointment.user_number
     *
     * @mbggenerated Thu Aug 03 16:47:27 CST 2017
     */
    public Integer getUserNumber() {
        return userNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column appointment.user_number
     *
     * @param userNumber the value for appointment.user_number
     *
     * @mbggenerated Thu Aug 03 16:47:27 CST 2017
     */
    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column appointment.appointment_time
     *
     * @return the value of appointment.appointment_time
     *
     * @mbggenerated Thu Aug 03 16:47:27 CST 2017
     */
    public Date getAppointmentTime() {
        return appointmentTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column appointment.appointment_time
     *
     * @param appointmentTime the value for appointment.appointment_time
     *
     * @mbggenerated Thu Aug 03 16:47:27 CST 2017
     */
    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column appointment.expect_return_time
     *
     * @return the value of appointment.expect_return_time
     *
     * @mbggenerated Thu Aug 03 16:47:27 CST 2017
     */
    public Date getExpectReturnTime() {
        return expectReturnTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column appointment.expect_return_time
     *
     * @param expectReturnTime the value for appointment.expect_return_time
     *
     * @mbggenerated Thu Aug 03 16:47:27 CST 2017
     */
    public void setExpectReturnTime(Date expectReturnTime) {
        this.expectReturnTime = expectReturnTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column appointment.real_return_time
     *
     * @return the value of appointment.real_return_time
     *
     * @mbggenerated Thu Aug 03 16:47:27 CST 2017
     */
    public Date getRealReturnTime() {
        return realReturnTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column appointment.real_return_time
     *
     * @param realReturnTime the value for appointment.real_return_time
     *
     * @mbggenerated Thu Aug 03 16:47:27 CST 2017
     */
    public void setRealReturnTime(Date realReturnTime) {
        this.realReturnTime = realReturnTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column appointment.status
     *
     * @return the value of appointment.status
     *
     * @mbggenerated Thu Aug 03 16:47:27 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column appointment.status
     *
     * @param status the value for appointment.status
     *
     * @mbggenerated Thu Aug 03 16:47:27 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointment{" +
            "id=" + id +
            ", bookId=" + bookId +
            ", userNumber=" + userNumber +
            ", appointmentTime=" + appointmentTime +
            ", expectReturnTime=" + expectReturnTime +
            ", realReturnTime=" + realReturnTime +
            ", status=" + status +
            '}';
    }
}