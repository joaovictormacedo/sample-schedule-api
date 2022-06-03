package br.com.macedo.scheduleapi.api.mapper;


import br.com.macedo.scheduleapi.api.dto.commons.*;
import br.com.macedo.scheduleapi.api.dto.request.*;
import br.com.macedo.scheduleapi.domain.vo.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface MapperApi {

    /* Rooms */
    RoomVO toRoomVO(RoomRequestDTO r);

    RoomDTO toRoomDTO(RoomVO r);


    /* Exam */
    ExamDTO toExamDTO(ExamVO e);

    ExamVO toExamVO(ExamRequestDTO e);
    ExamVO toExamVO(ExamDTO e);


    /* Candidate */
    CandidateVO toCandidateVO(CandidateRequestDTO c);
    CandidateVO toCandidateVO(CandidateDTO c);

    CandidateDTO toCandidateDTO(CandidateVO c);


    /* Availability */
    AvailabilityDTO toAvailabilityDTO(AvailabilityVO v);
    List<AvailabilityDTO> toListAvailabilityDTO(List<AvailabilityVO> v);

    AvailabilityVO toAvailabilityVO(AvailabilityRequestDTO v);

    AvailabilityVO toAvailabilityVO(AvailabilityDTO v);


    /* Schedule */
    ScheduleDTO toScheduleDTO(ScheduleVO s);

    @Mapping(target = "room.number", source = "roomId")
    @Mapping(target = "candidate.id", source = "candidateId")
    @Mapping(target = "exam.id", source = "examId")
    @Mapping(target = "date", source = "date")
    ScheduleVO toScheduleVO(ScheduleRequestDTO s);

    List<CandidateVO> toListCandidateDTO(List<CandidateVO> c);

    List<ExamDTO> toListExamDTO(List<ExamVO> l);

    List<RoomDTO> toListRoomDTO(List<RoomVO> r);

    List<ScheduleDTO> toListscheduleDTO(List<ScheduleVO> lstSchedule);
}
