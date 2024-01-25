package com.aconso.casestudy.api;

import com.aconso.casestudy.db.entity.Absence;
import com.aconso.casestudy.db.entity.Employee;
import com.aconso.casestudy.db.repo.AbsenceRepository;
import com.aconso.casestudy.db.repo.EmployeeRepository;
import com.aconso.casestudy.model.AbsenceDto;
import com.aconso.casestudy.model.EmployeeDto;
import com.aconso.casestudy.rest.AbsenceMapper;
import com.aconso.casestudy.rest.EmployeeMapper;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeApiDelegateImpl implements EmployeeApiDelegate {


  private final EmployeeRepository employeeRepository;
  private final AbsenceRepository absenceRepository;
  private final EmployeeMapper employeeMapper;
  private final AbsenceMapper absenceMapper;

  public EmployeeApiDelegateImpl(@Autowired EmployeeRepository employeeRepository, @Autowired
  EmployeeMapper employeeMapper, @Autowired AbsenceRepository absenceRepository,
      @Autowired AbsenceMapper absenceMapper) {
    this.employeeRepository = employeeRepository;
    this.employeeMapper = employeeMapper;
    this.absenceRepository = absenceRepository;
    this.absenceMapper = absenceMapper;
  }

  public ResponseEntity<List<EmployeeDto>> getAllEmployees() {

    List<Employee> all = employeeRepository.findAll();
    List<EmployeeDto> employeeDto = employeeMapper.employeeToEmployeeDto(all);
    return ResponseEntity.of(Optional.of(employeeDto));
  }


  public ResponseEntity<EmployeeDto> getEmployeeById(String id) {
    UUID uuid = UUID.fromString(id);
    Employee userById = employeeRepository.findUserById(uuid);
    return ResponseEntity.of(Optional.of(employeeMapper.employeeToEmployeeDto(userById)));
  }

  public ResponseEntity<Void> addAbstance(String id,
      AbsenceDto absenceDto) {
    Absence absence = absenceMapper.absenceDtoToAbsence(absenceDto);
    if (Objects.isNull(absence.getId())) {
      absence.setId(UUID.randomUUID());
    }
    UUID uuid = UUID.fromString(id);
    Employee userById = employeeRepository.findUserById(uuid);

    if (Objects.nonNull(userById)) {
      absence.setEmployee(userById);
    } else {
      new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    absenceRepository.saveAndFlush(absence);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  public ResponseEntity<List<AbsenceDto>> getAbsenceForEmployee(String id) {
    UUID uuid = UUID.fromString(id);
    List<Absence> byUserId = absenceRepository.findByUserId(uuid);

    List<AbsenceDto> absenceDtos = absenceMapper.absenceToAbsenceDto(byUserId);

    return ResponseEntity.of(Optional.of(absenceDtos));
  }
}
