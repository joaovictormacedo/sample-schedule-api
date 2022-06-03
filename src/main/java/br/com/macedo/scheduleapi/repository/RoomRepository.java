package br.com.macedo.scheduleapi.repository;

import br.com.macedo.scheduleapi.domain.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
