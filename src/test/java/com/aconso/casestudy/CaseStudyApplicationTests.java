package com.aconso.casestudy;

import com.aconso.casestudy.db.entity.Absence;
import com.aconso.casestudy.db.entity.Employee;
import com.aconso.casestudy.rest.AbsenceDtoMapper;
import com.aconso.casestudy.rest.EmployeeController;
import com.aconso.casestudy.service.RepositoryService;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class CaseStudyApplicationTests {
  @Autowired
  private RepositoryService repositoryService;
  @Autowired
  private AbsenceDtoMapper absenceDtoMapper;

  @Autowired
  private EmployeeController employeeController;
  @Test
  void contextLoads() {
    Absence absence = new Absence();
    absence.setFrom(new Date());
    Calendar calendar = new GregorianCalendar(Locale.GERMANY);
    calendar.set(2024, 2, 23);
    absence.setTo(calendar.getTime());

    Employee karl = repositoryService.findUserByName("Karl").get();
    absence.setEmployee(karl);
    employeeController.addAbstance(karl.getId().toString(), absenceDtoMapper.toDto(absence));

  }

}
