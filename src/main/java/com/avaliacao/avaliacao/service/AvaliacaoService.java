package com.avaliacao.avaliacao.service;

import com.avaliacao.avaliacao.model.Avaliacao;
import com.avaliacao.avaliacao.repository.AvaliacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public List<Avaliacao> findAll() {
        return avaliacaoRepository.findAll();
    }

    public Avaliacao findById(Long id) {
        return avaliacaoRepository.findById(id).orElse(null);
    }

    public Avaliacao save(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    public void delete(Long id) {
        avaliacaoRepository.deleteById(id);
    }
}
