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
@Schema(name = "Availability", description = "room availability")
public class AvailabilityDTO {

    private RoomDTO room;
    private LocalDateTime date;

}
