package br.com.dogplay.controllers;


import br.com.dogplay.models.Servico;
import br.com.dogplay.models.Tutor;
import br.com.dogplay.services.TutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/tutor")

public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @PostMapping
    public ResponseEntity<Tutor> save(@RequestBody Tutor tutor) {
        Tutor aux = tutorService.save(tutor);
        return ResponseEntity.ok(aux);
    }

    @GetMapping
    public ResponseEntity<List<Tutor>> findAll() {
        return ResponseEntity.ok(tutorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutor> buscar(@PathVariable Long id) {
        var aux = tutorService.findById(id);
        return ResponseEntity.ok(aux);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutor> atualizar(@PathVariable Long id, @RequestBody Tutor tutor) {
        var aux = tutorService.update(tutor, id);
        return ResponseEntity.ok(aux);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tutor> apagar (@PathVariable Long id) {
        tutorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}