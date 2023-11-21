package com.aconso.casestudy;

import com.aconso.casestudy.db.entity.Absence;
import com.aconso.casestudy.db.entity.Employee;
import com.aconso.casestudy.service.RepositoryService;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryServiceTest {

  @Autowired
  private RepositoryService repositoryService;

  @Test
  public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
    List<Employee> users = repositoryService.listAllUsers();
    Assert.assertEquals(users.size(), 3);
  }

  @Test
  public void addUser() {
    Employee employee = new Employee();
    employee.setName("Fanz");
    employee.setPosition("Operating");
    employee.setTenant("tenant42");
    repositoryService.addUser(employee);
    List<Employee> users = repositoryService.listAllUsers();
    Assert.assertEquals(users.size(), 4);
  }

  @Test
  public void findUserByName(){
    Optional<Employee> employee = repositoryService.findUserByName("Karl");
    Assert.assertTrue(employee.isPresent());
  }

  @Test
  public void listAbsence(){
    List<Absence> absences = repositoryService.listAbsence();
    Assert.assertEquals(absences.size(), 3);
  }

  @Test
  public void addAbsence(){
    Optional<Employee> employee = repositoryService.findUserByName("Karl");

    Absence absence = new Absence();
    absence.setEmployee(employee.get());
    absence.setFrom(new Date());
    absence.setTo(new Date(2023-12-12));
    repositoryService.addAbsence(absence);
    List<Absence> absences = repositoryService.listAbsence();
    Assert.assertEquals(absences.size(), 4);
  }


}
