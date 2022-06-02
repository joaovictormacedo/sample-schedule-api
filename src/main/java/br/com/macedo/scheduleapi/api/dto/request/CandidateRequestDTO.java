package br.com.macedo.scheduleapi.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "CandidateInsert", description = "candidate data insert")
public class CandidateRequestDTO {

    private String name;
    private String email;

}
