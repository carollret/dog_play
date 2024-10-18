package br.com.dogplay.controllers;

import br.com.dogplay.models.Pets;
import br.com.dogplay.services.PetsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//import java.util.UUID;

@RestController
@RequestMapping("/pets")
public class PetsController {

    private final PetsService petsService;

    public PetsController(PetsService petsService) {
        this.petsService = petsService;
    }

    @PostMapping
    public ResponseEntity<Pets> save(@RequestBody Pets pets) {
        Pets aux = petsService.savePet(pets);
        return ResponseEntity.ok(aux);
    }

    @GetMapping
    public ResponseEntity<List<Pets>> findAll() {
        return ResponseEntity.ok(petsService.getAllPets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pets> buscar(@PathVariable Long id) {
        Optional<Pets> aux = petsService.getPetById(id);
        return aux.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pets> atualizar(@PathVariable Long id, @RequestBody Pets pets) {
        var aux = petsService.update(pets, id);
        return ResponseEntity.ok(aux);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pets> apagar(@PathVariable Long id) {
        petsService.deletePet(id);
        return ResponseEntity.noContent().build();
    }
}
