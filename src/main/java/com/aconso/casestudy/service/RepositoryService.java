package com.aconso.casestudy.service;

import com.aconso.casestudy.db.entity.Absence;
import com.aconso.casestudy.db.entity.Employee;
import com.aconso.casestudy.db.repo.AbsenceRepository;
import com.aconso.casestudy.db.repo.EmployeeRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepositoryService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private AbsenceRepository absenceRepository;

  public List<Employee> listAllUsers() {
    return employeeRepository.findAll();
  }

  public List<Absence> listAbsence() {
    return absenceRepository.findAll();
  }

  public List<Absence> listAbsenceForUser(String userId) {
    UUID uuid = UUID.fromString(userId);
    return absenceRepository.findByUserId(uuid);
  }

  public void addAbsence(Absence absence) {
    if (Objects.isNull(absence.getId())) {
      absence.setId(UUID.randomUUID());
    }
    absenceRepository.saveAndFlush(absence);
  }

  public void addUser(Employee employee) {
    if (Objects.isNull(employee.getId())) {
      employee.setId(UUID.randomUUID());
    }
    employeeRepository.saveAndFlush(employee);
  }

  public Optional<Employee> findUserByName(String name) {
    Employee byName = employeeRepository.findByName(name);
    return Optional.of(byName);
  }

  public Employee findUserById(String userId) {
    UUID uuid = UUID.fromString(userId);
    return employeeRepository.findUserById(uuid);
  }
}
