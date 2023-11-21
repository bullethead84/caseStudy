package com.aconso.casestudy.rest;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.Date;

public class AbsenceDto {

  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date from;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date to;
  private String reason;

  public Date getFrom() {
    return from;
  }

  public void setFrom(Date from) {
    this.from = from;
  }

  public Date getTo() {
    return to;
  }

  public void setTo(Date to) {
    this.to = to;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }


}
