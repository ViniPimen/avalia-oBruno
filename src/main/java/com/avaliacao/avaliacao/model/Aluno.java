package com.avaliacao.avaliacao.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Aluno")
@Entity
@Data
@Builder
@DiscriminatorValue("Aluno")
@EqualsAndHashCode(callSuper = true)
public class Aluno extends Pessoa {
    private String matricula;
    private String situacao;
    public void matricularCurso() {}
    public void trancar() {}
    public void formar() {}
    public void evadir() {}
    public void obterAvaliacoes() {}
    public void emitirHistorico() {}

    @ManyToMany(mappedBy = "alunos")
    private Set<Turma> turmas = new HashSet<>();
}
