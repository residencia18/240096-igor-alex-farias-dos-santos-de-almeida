package org.db_crud.db_crud.controller.form;

import org.db_crud.db_crud.model.Aluno;

public class AlunoForm {

    private String nome;
    private String cpf;
    private String curso;

    public AlunoForm() {
    }

    public AlunoForm(String nome, String cpf, String curso) {
        this.nome = nome;
        this.cpf = cpf;
        this.curso = curso;
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

    public Aluno criaAluno(){
        return new Aluno(null, nome, cpf, curso);
    }
}
