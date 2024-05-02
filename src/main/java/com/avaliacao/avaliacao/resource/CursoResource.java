package com.avaliacao.avaliacao.resource;

import com.avaliacao.avaliacao.model.Curso;
import com.avaliacao.avaliacao.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoResource {

    private final CursoService cursoService;

    public CursoResource(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public ResponseEntity<List<Curso>> getAll() {
        List<Curso> cursos = cursoService.findAll();
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getOne(@PathVariable Long id) {
        Curso curso = cursoService.findById(id);
        if (curso == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(curso);
    }

    @PostMapping
    public ResponseEntity<Curso> create(@RequestBody Curso curso) {
        Curso savedCurso = cursoService.save(curso);
        return ResponseEntity.ok(savedCurso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@PathVariable Long id, @RequestBody Curso curso) {
        if (!id.equals(curso.getCodigo())) {
            return ResponseEntity.badRequest().build();
        }
        Curso updatedCurso = cursoService.save(curso);
        return ResponseEntity.ok(updatedCurso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cursoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
