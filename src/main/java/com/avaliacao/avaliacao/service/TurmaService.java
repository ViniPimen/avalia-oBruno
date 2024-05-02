package com.avaliacao.avaliacao.service;

import com.avaliacao.avaliacao.model.Turma;
import com.avaliacao.avaliacao.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }

    public Turma findById(Long id) {
        return turmaRepository.findById(id).orElse(null);
    }

    public Turma save(Turma turma) {
        return turmaRepository.save(turma);
    }

    public boolean delete(Long id) {
        turmaRepository.deleteById(id);
        return false;
    }

}
