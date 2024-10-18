package br.com.dogplay.controllers;


import br.com.dogplay.models.Prestador;
import br.com.dogplay.services.PrestadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestador")

public class PrestadorController {

    private final PrestadorService prestadorService;

    public PrestadorController (PrestadorService prestadorService) {
        this.prestadorService = prestadorService;
    }

    @PostMapping
    public ResponseEntity<Prestador> save(@RequestBody Prestador prestador) {
        Prestador aux = prestadorService.save(prestador);
        return ResponseEntity.ok(aux);
    }

    @GetMapping
    public ResponseEntity<List<Prestador>> findAll() {
        return ResponseEntity.ok(prestadorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestador> buscar(@PathVariable Long id) {
        var aux = prestadorService.findById(id);
        return ResponseEntity.ok(aux);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestador> atualizar(@PathVariable Long id, @RequestBody Prestador prestador) {
        var aux = prestadorService.update(prestador, id);
        return ResponseEntity.ok(aux);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Prestador> apagar (@PathVariable Long id) {
        prestadorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}