package br.com.macedo.scheduleapi.api.dto.commons;

import br.com.macedo.scheduleapi.api.dto.commons.AvailabilityDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Room", description = "room information")
public class RoomDTO {

    private Integer number;
    private List<AvailabilityDTO> availabilities;

}
