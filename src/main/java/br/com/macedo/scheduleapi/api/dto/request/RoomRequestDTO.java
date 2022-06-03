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
@Schema(name = "RoomInsert", description = "room data insert")
public class RoomRequestDTO {

    private Integer number;

}
