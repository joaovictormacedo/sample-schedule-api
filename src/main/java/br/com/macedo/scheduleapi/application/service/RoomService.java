package br.com.macedo.scheduleapi.application.service;

import br.com.macedo.scheduleapi.domain.vo.RoomVO;
import org.springframework.stereotype.Service;


public interface RoomService {

    RoomVO insert(RoomVO room);

}
