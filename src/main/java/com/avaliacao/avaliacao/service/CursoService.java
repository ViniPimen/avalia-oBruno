package com.avaliacao.avaliacao.service;

import com.avaliacao.avaliacao.model.Curso;
import com.avaliacao.avaliacao.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Curso findById(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    public void delete(Long id) {
        cursoRepository.deleteById(id);
    }
}
