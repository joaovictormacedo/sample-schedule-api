package br.com.macedo.scheduleapi.repository;

import br.com.macedo.scheduleapi.domain.entities.Availability;
import br.com.macedo.scheduleapi.domain.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {

    List<Availability> findByRoomAndDate(Room room, LocalDateTime date);

}
