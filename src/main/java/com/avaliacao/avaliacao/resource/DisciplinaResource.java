package com.avaliacao.avaliacao.resource;

import com.avaliacao.avaliacao.model.Disciplina;
import com.avaliacao.avaliacao.service.DisciplinaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaResource {

    private final DisciplinaService disciplinaService;

    public DisciplinaResource(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @GetMapping
    public ResponseEntity<List<Disciplina>> getAll() {
        List<Disciplina> disciplinas = disciplinaService.findAll();
        return ResponseEntity.ok(disciplinas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> getOne(@PathVariable Long id) {
        Disciplina disciplina = disciplinaService.findById(id);
        if (disciplina == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(disciplina);
    }

    @PostMapping
    public ResponseEntity<Disciplina> create(@RequestBody Disciplina disciplina) {
        Disciplina savedDisciplina = disciplinaService.save(disciplina);
        return ResponseEntity.ok(savedDisciplina);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> update(@PathVariable Long id, @RequestBody Disciplina disciplina) {
        if (!id.equals(disciplina.getCodigo())) {
            return ResponseEntity.badRequest().build();
        }
        Disciplina updatedDisciplina = disciplinaService.save(disciplina);
        return ResponseEntity.ok(updatedDisciplina);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        disciplinaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
