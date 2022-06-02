package br.com.macedo.scheduleapi.api.dto.commons;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Exam", description = "Exam informations")
public class ExamDTO {

    private Long id;
    private String name;
    private LocalDateTime date;

}
