package com.aconso.casestudy.rest;

import com.aconso.casestudy.db.entity.Absence;
import com.aconso.casestudy.model.AbsenceDto;
import java.util.Collection;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AbsenceMapper {

  AbsenceDto absenceToAbsenceDto(Absence absence);

  Absence absenceDtoToAbsence(AbsenceDto absenceDto);

  List<AbsenceDto> absenceToAbsenceDto(Collection<Absence> absenceCollection);
}
