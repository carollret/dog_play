package br.com.dogplay.controllers;

import br.com.dogplay.models.Prestador;
import br.com.dogplay.models.Servico;
import br.com.dogplay.services.PrestadorService;
import br.com.dogplay.services.ServicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/servico")

public class ServicoController {

    private final ServicoService servicoService;

    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @PostMapping
    public ResponseEntity<Servico> save(@RequestBody Servico servico) {
        Servico aux = servicoService.save(servico);
        return ResponseEntity.ok(aux);
    }

    @GetMapping
    public ResponseEntity<List<Servico>> findAll() {
        return ResponseEntity.ok(servicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> buscar(@PathVariable UUID id) {
        var aux = servicoService.findById(id);
        return ResponseEntity.ok(aux);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> atualizar(@PathVariable UUID id, @RequestBody Servico servico) {
        var aux = servicoService.update(servico, id);
        return ResponseEntity.ok(aux);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Servico> apagar (@PathVariable UUID id) {
        servicoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}