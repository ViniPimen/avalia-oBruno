package com.avaliacao.avaliacao.resource;

import com.avaliacao.avaliacao.model.Turma;
import com.avaliacao.avaliacao.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/turmas")
public class TurmaResource {

    @Autowired
    private TurmaService turmaService;

    // GET - Listar todas as turmas
    @GetMapping
    public ResponseEntity<List<Turma>> getAllTurmas() {
        List<Turma> turmas = turmaService.findAll();
        return ResponseEntity.ok(turmas);
    }

    // GET - Obter uma turma pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Turma> getTurmaById(@PathVariable Long id) {
        Turma turma = turmaService.findById(id);
        if (turma != null) {
            return ResponseEntity.ok(turma);
        }
        return ResponseEntity.notFound().build();
    }

    // POST - Criar uma nova turma
    @PostMapping
    public ResponseEntity<Turma> createTurma(@RequestBody Turma turma) {
        Turma newTurma = turmaService.save(turma);
        return ResponseEntity.created(URI.create("/api/turmas/" + newTurma.getId_turma())).body(newTurma);
    }


    // DELETE - Deletar uma turma
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTurma(@PathVariable Long id) {
        if (turmaService.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
