package com.aconso.casestudy.rest;

import com.aconso.casestudy.db.entity.Employee;
import com.aconso.casestudy.model.EmployeeDto;
import java.util.Collection;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

  EmployeeDto employeeToEmployeeDto(Employee employee);

  Employee employeeDtoToEmplooyee(EmployeeDto employeeDto);

  List<EmployeeDto> employeeToEmployeeDto(Collection<Employee> employeeCollection);
}
