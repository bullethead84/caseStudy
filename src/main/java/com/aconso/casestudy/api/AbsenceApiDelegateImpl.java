package com.aconso.casestudy.api;

import com.aconso.casestudy.db.entity.Absence;
import com.aconso.casestudy.db.repo.AbsenceRepository;
import com.aconso.casestudy.model.AbsenceDto;
import com.aconso.casestudy.rest.AbsenceMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AbsenceApiDelegateImpl implements AbsenceApiDelegate {

  private final AbsenceRepository absenceRepository;
  private final AbsenceMapper absenceMapper;

  public AbsenceApiDelegateImpl(@Autowired AbsenceRepository absenceRepository, @Autowired
  AbsenceMapper absenceMapper) {
    this.absenceRepository = absenceRepository;
    this.absenceMapper = absenceMapper;
  }

  public ResponseEntity<List<AbsenceDto>> getAllAbsence() {
    List<Absence> all = absenceRepository.findAll();

    List<AbsenceDto> absenceDtos = absenceMapper.absenceToAbsenceDto(all);

    return ResponseEntity.of(Optional.of(absenceDtos));
  }
}
