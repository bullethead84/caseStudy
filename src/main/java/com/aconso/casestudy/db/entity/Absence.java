package com.aconso.casestudy.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import java.util.UUID;
import jakarta.validation.constraints.NotNull;
@Entity
public class Absence {

  @Id
  private UUID id;

  @NotNull
  private Date from;
  private Date to;
  @NotNull
  private String reason;
  @ManyToOne
  @NotNull
  private Employee employee;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

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

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }



}
