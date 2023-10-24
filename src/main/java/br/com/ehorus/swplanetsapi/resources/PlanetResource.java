package br.com.ehorus.swplanetsapi.resources;

import br.com.ehorus.swplanetsapi.model.Planet;
import br.com.ehorus.swplanetsapi.repository.PlanetRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
public class PlanetResource {
    @Autowired
    PlanetRepository planetRepository;

    @Operation(summary="Retorna uma lista de planetas")
    @GetMapping("/planets")
    public List<Planet> listPlanets() {
        return planetRepository.findAll();
    }

    @Operation(summary="Busca um planeta por id")
    @GetMapping("/planet/{id}")
    public Planet listPlanetById(@PathVariable(value="id") long id) {
        return planetRepository.findById(id);
    }

    @Operation(summary="Busca um planeta por nome")
    @GetMapping("/planet/name")
    public List<Planet> listPlanetByName(@RequestParam String name) {
        return planetRepository.findByName(name);
    }

    @Operation(summary="Salva um planeta no banco de dados")
    @PostMapping("/planet")
    public Planet savePlanet(@RequestBody Planet planet){
        return planetRepository.save(planet);
    }

    @Operation(summary="Apaga um planeta no banco de dados")
    @DeleteMapping("/planet")
    public void deletePlanet(@RequestBody Planet planet) {
        planetRepository.delete(planet);
    }
}
