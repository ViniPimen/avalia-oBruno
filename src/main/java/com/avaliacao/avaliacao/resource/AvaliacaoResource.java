package com.avaliacao.avaliacao.resource;

import com.avaliacao.avaliacao.model.Avaliacao;
import com.avaliacao.avaliacao.service.AvaliacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoResource {

    private final AvaliacaoService avaliacaoService;

    public AvaliacaoResource(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @GetMapping
    public ResponseEntity<List<Avaliacao>> getAll() {
        List<Avaliacao> avaliacoes = avaliacaoService.findAll();
        return ResponseEntity.ok(avaliacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> getOne(@PathVariable Long id) {
        Avaliacao avaliacao = avaliacaoService.findById(id);
        if (avaliacao == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(avaliacao);
    }

    @PostMapping
    public ResponseEntity<Avaliacao> create(@RequestBody Avaliacao avaliacao) {
        Avaliacao savedAvaliacao = avaliacaoService.save(avaliacao);
        return ResponseEntity.ok(savedAvaliacao);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        avaliacaoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
