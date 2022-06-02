package br.com.macedo.scheduleapi.domain.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Room {

    @Id
    @Column(unique = true, nullable = false, updatable = false)
    private Integer number;

    @OneToMany
    private List<Availability> availabilities;

}
