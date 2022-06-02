package br.com.macedo.scheduleapi.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AvailabilityVO {

    private Long id;
    private RoomVO room;
    private CandidateVO candidate;
    private ExamVO exam;
    private LocalDateTime date;

}
