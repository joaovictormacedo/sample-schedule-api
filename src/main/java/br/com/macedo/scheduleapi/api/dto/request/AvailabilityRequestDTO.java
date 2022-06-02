package br.com.macedo.scheduleapi.api.dto.request;

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
@Schema(name = "AvailabilityReqDTO", description = "availability data insert")
public class AvailabilityRequestDTO {

    private RoomRequestDTO room;
    private LocalDateTime date;

}
