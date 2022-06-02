package br.com.macedo.scheduleapi.repository;

import br.com.macedo.scheduleapi.domain.entities.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {

}
