package br.com.macedo.scheduleapi.application.service.impl;

import br.com.macedo.scheduleapi.application.service.ExamService;
import br.com.macedo.scheduleapi.domain.vo.ExamVO;
import br.com.macedo.scheduleapi.mapper.EntitiesMapper;
import br.com.macedo.scheduleapi.repository.ExamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExameServiceImpl implements ExamService {

    private ExamRepository examRepository;

    private EntitiesMapper entitiesMapper;

    @Override
    public ExamVO insert(ExamVO e) {
        return entitiesMapper.toExamVo(
                examRepository.save(entitiesMapper.toExam(e))
        );
    }
}
