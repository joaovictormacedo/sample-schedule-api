package br.com.macedo.scheduleapi.mapper;

import br.com.macedo.scheduleapi.domain.entities.Availability;
import br.com.macedo.scheduleapi.domain.entities.Candidate;
import br.com.macedo.scheduleapi.domain.entities.Exam;
import br.com.macedo.scheduleapi.domain.entities.Room;
import br.com.macedo.scheduleapi.domain.vo.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EntitiesMapper {

    Room toRoom(RoomVO r);

    RoomVO toRoomVo(Room r);

    ExamVO toExamVo(Exam e);

    Exam toExam(ExamVO e);

    CandidateVO toCandidateVO(Candidate c);

    Candidate toCandidate(CandidateVO c);

    AvailabilityVO toAvailabilityVO(Availability a);
    List<AvailabilityVO> toListAvailabilityVO(List<Availability> a);

    Availability toAvailability(AvailabilityVO a);

    Availability toAvailability(ScheduleVO s);

    ScheduleVO toScheduleVO(Availability a);

    List<CandidateVO> toListCandidate(List<Candidate> c);

    List<ExamVO> toListExamVo(List<Exam> e);

    List<RoomVO> toListRoomVO(List<Room> r);

    List<ScheduleVO> toListScheduleVO(List<Availability> a);
}
