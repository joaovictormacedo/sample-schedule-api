package br.com.macedo.scheduleapi.application.service.impl;

import br.com.macedo.scheduleapi.application.service.CandidateService;
import br.com.macedo.scheduleapi.domain.exception.ClientException;
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

    @Override
    public void delete(Long id) {

        var candidate = candidateRepository.findById(id).orElseThrow(()->
                new ClientException(new Exception("Client not found")));

        try{
            candidateRepository.delete(candidate);
        }catch (Exception e){
            throw new ClientException(new Exception("failed to delete candidate"));
        }

    }

    @Override
    public CandidateVO update(CandidateVO c) {
        return entitiesMapper.toCandidateVO(candidateRepository.save(entitiesMapper.toCandidate(c)));
    }
}
