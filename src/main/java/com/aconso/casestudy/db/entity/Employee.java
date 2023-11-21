package com.aconso.casestudy.db.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;

@Entity
public class Employee {

  @Id
  private UUID id;
  private String name;
  private String tenant;
  private String position;


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTenant() {
    return tenant;
  }

  public void setTenant(String tenant) {
    this.tenant = tenant;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }


  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getId() {
    return id;
  }
}
