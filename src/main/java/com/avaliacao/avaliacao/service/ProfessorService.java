package com.avaliacao.avaliacao.service;

import com.avaliacao.avaliacao.model.Professor;
import com.avaliacao.avaliacao.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public Professor findById(Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    public void delete(Long id) {
        professorRepository.deleteById(id);
    }
}
