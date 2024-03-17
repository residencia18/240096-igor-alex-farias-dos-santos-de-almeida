package org.db_crud.db_crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class   Aluno {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matricula;
    private String nome;
    private String cpf;
    private String curso;

    public Aluno() {
    }

    public Aluno(Integer matricula, String nome, String cpf, String curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.curso = curso;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
