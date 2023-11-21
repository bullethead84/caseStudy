package com.aconso.casestudy.rest;


import com.aconso.casestudy.db.entity.Absence;
import com.aconso.casestudy.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class AbsenceDtoMapper {


  private RepositoryService repositoryService;

  @Autowired
  AbsenceDtoMapper(RepositoryService repositoryService) {
    this.repositoryService = repositoryService;
  }

  public Absence toAbsence(AbsenceDto dto, String id) {
    Absence absence = new Absence();
    absence.setFrom(dto.getFrom());
    absence.setTo(dto.getTo());
    absence.setEmployee(repositoryService.findUserById(id));
    absence.setReason(dto.getReason());
    return absence;
  }
}