package br.com.macedo.scheduleapi.application.service;

import br.com.macedo.scheduleapi.domain.vo.ScheduleVO;

import java.util.List;

public interface ScheduleService {

    ScheduleVO insert(ScheduleVO s);

    void delete(Long id);

    ScheduleVO getById(Long id);

    List<ScheduleVO> get();

}
