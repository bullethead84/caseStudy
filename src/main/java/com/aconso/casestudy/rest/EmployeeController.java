package com.aconso.casestudy.rest;

import com.aconso.casestudy.db.entity.Absence;
import com.aconso.casestudy.db.entity.Employee;
import com.aconso.casestudy.service.RepositoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

  private RepositoryService repositoryService;
private AbsenceDtoMapper mapper;

  @Autowired
  EmployeeController(RepositoryService repositoryService, AbsenceDtoMapper mapper) {
    this.repositoryService = repositoryService;
    this.mapper = mapper;
  }

  @GetMapping("/absence")
  List<Absence> getAbsence() {
    return repositoryService.listAbsence();
  }


  @PostMapping("/employee/{id}")
  public void addAbstance(@PathVariable String id, @RequestBody AbsenceDto absence) {
    repositoryService.addAbsence(mapper.toAbsence(absence, id));
  }

  @GetMapping("/employee")
  List<Employee> all() {
    return repositoryService.listAllUsers();
  }

  @GetMapping("/employee/{id}")
  Employee getEmpoyee(@PathVariable String id) {
    return repositoryService.findUserById(id);
  }


  @GetMapping("/employee/{id}/absence")
  List<Absence> all(@PathVariable String id) {
    return repositoryService.listAbsenceForUser(id);
  }


}
