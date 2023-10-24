package br.com.ehorus.swplanetsapi.repository;

import br.com.ehorus.swplanetsapi.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
    Planet findById(long id);

    List<Planet> findByName(String name);
}
