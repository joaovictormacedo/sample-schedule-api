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
public class ExamVO {

    private Long id;
    private String name;
    private LocalDateTime date;

}
