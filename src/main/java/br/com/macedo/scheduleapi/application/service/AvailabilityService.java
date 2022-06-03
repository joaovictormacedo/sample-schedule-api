package br.com.macedo.scheduleapi.application.service;

import br.com.macedo.scheduleapi.domain.vo.AvailabilityVO;

import java.util.List;

public interface AvailabilityService {

    AvailabilityVO insert(AvailabilityVO a);
    void delete(Long id);
    AvailabilityVO update(AvailabilityVO a);

    AvailabilityVO getById(Long id);
    List<AvailabilityVO> getAll();

}
