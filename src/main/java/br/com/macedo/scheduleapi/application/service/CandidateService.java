package br.com.macedo.scheduleapi.application.service;

import br.com.macedo.scheduleapi.domain.vo.CandidateVO;

public interface CandidateService {

    CandidateVO insert(CandidateVO c);
    void delete(Long id);
    CandidateVO update(CandidateVO c);

}
