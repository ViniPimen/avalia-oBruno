package com.avaliacao.avaliacao.resource;

import com.avaliacao.avaliacao.model.Professor;
import com.avaliacao.avaliacao.service.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorResource {

    private final ProfessorService professorService;

    public ProfessorResource(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public ResponseEntity<List<Professor>> getAll() {
        List<Professor> professores = professorService.findAll();
        return ResponseEntity.ok(professores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> getOne(@PathVariable Long id) {
        Professor professor = professorService.findById(id);
        if (professor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(professor);
    }

    @PostMapping
    public ResponseEntity<Professor> create(@RequestBody Professor professor) {
        Professor savedProfessor = professorService.save(professor);
        return ResponseEntity.ok(savedProfessor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> update(@PathVariable Long id, @RequestBody Professor professor) {
        if (!id.equals(professor.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Professor updatedProfessor = professorService.save(professor);
        return ResponseEntity.ok(updatedProfessor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        professorService.delete(id);
        return ResponseEntity.ok().build();
    }
}
