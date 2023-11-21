package com.aconso.casestudy.db.repo;

import com.aconso.casestudy.db.entity.Absence;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {

  @Query("SELECT a FROM Absence a WHERE a.employee.id = ?1")
  List<Absence> findByUserId(UUID userid);

}
