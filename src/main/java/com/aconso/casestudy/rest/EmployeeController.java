package com.aconso.casestudy.rest;

import com.aconso.casestudy.db.entity.Absence;
import com.aconso.casestudy.db.entity.Employee;
import com.aconso.casestudy.service.RepositoryService;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

  private RepositoryService repositoryService;

  @Autowired
  EmployeeController(RepositoryService repositoryService) {
    this.repositoryService = repositoryService;
  }

  @GetMapping("/absence")
  List<Absence> getAbsence() {
    return repositoryService.listAbsence();
  }


  @PostMapping("/employees/{id}")
  public void addAbstance(@PathVariable String id, Absence absence) {
    if (Objects.isNull(absence.getId())) {
      absence.setId(UUID.randomUUID());
    }
    absence.setEmployee(repositoryService.findUserById(id));
    repositoryService.addAbsence(absence);
  }

  @GetMapping("/employees")
  List<Employee> all() {
    return repositoryService.listAllUsers();
  }

  @GetMapping("/employees/{id}")
  Employee getEmpoyee(@PathVariable String id) {
    return repositoryService.findUserById(id);
  }


  @GetMapping("/employees/{id}/absence")
  List<Absence> all(@PathVariable String id) {
    return repositoryService.listAbsenceForUser(id);
  }


}
