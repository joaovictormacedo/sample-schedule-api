package br.com.macedo.scheduleapi.application.service.impl;

import br.com.macedo.scheduleapi.application.service.CandidateService;
import br.com.macedo.scheduleapi.domain.vo.CandidateVO;
import br.com.macedo.scheduleapi.mapper.EntitiesMapper;
import br.com.macedo.scheduleapi.repository.CandidateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private CandidateRepository candidateRepository;

    private EntitiesMapper entitiesMapper;

    @Override
    public CandidateVO insert(CandidateVO c) {
        return entitiesMapper.toCandidateVO(candidateRepository.save(entitiesMapper.toCandidate(c)));
    }
}
