package br.com.macedo.scheduleapi.repository;

import br.com.macedo.scheduleapi.domain.entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
}
