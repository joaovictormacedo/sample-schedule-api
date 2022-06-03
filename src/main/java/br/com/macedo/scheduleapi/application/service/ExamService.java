package br.com.macedo.scheduleapi.application.service;

import br.com.macedo.scheduleapi.domain.vo.ExamVO;

import java.util.List;

public interface ExamService {

    ExamVO insert(ExamVO e);
    ExamVO update(ExamVO e);
    void delete(Long id);
    ExamVO getById(Long id);
    List<ExamVO> get();

}
