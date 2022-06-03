package br.com.macedo.scheduleapi.application.service.impl;

import br.com.macedo.scheduleapi.application.service.ExamService;
import br.com.macedo.scheduleapi.domain.exception.ClientException;
import br.com.macedo.scheduleapi.domain.vo.ExamVO;
import br.com.macedo.scheduleapi.mapper.EntitiesMapper;
import br.com.macedo.scheduleapi.repository.ExamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public ExamVO update(ExamVO e) {
        return entitiesMapper.toExamVo(
                examRepository.save(entitiesMapper.toExam(e))
        );
    }

    @Override
    public void delete(Long id) {
        var exam = examRepository.findById(id).orElseThrow(()->
                new ClientException(new Exception("Exam not found")));

        try{
            examRepository.delete(exam);
        }catch (Exception e){
            throw new ClientException(new Exception("Fail to delete exam"));
        }

    }

    @Override
    public ExamVO getById(Long id) {
        var exam = examRepository.findById(id).orElseThrow(()->
                new ClientException(new Exception("Exam not found")));

        return entitiesMapper.toExamVo(exam);
    }

    @Override
    public List<ExamVO> get() {
        return  entitiesMapper.toListExamVo(examRepository.findAll());
    }
}
