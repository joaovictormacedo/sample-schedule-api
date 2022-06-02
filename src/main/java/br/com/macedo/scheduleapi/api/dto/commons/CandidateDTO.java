package br.com.macedo.scheduleapi.api.dto.commons;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Candidate", description = "candidate information")
public class CandidateDTO {

    private Long id;
    private String name;
    private String email;

}
