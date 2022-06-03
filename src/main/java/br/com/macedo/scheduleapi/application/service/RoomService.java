package br.com.macedo.scheduleapi.application.service;

import br.com.macedo.scheduleapi.domain.vo.RoomVO;

import java.util.List;


public interface RoomService {

    RoomVO insert(RoomVO room);
    void delete(Integer id);
    RoomVO getById(Integer id);
    List<RoomVO> get();

}
