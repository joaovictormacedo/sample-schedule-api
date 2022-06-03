package br.com.macedo.scheduleapi.domain.vo;

import br.com.macedo.scheduleapi.api.dto.commons.AvailabilityDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomVO {

    private Integer number;
    private List<AvailabilityDTO> availabilities;

}
