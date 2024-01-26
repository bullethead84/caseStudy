package com.aconso.casestudy.db.repo;

import com.aconso.casestudy.db.entity.Employee;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  @Query("SELECT t FROM Employee t WHERE t.id = ?1")
  Employee findUserById(UUID id);
}
