package org.db_crud.db_crud.controller.dto;

import org.db_crud.db_crud.model.Aluno;

public class AlunoDTO {

    private Integer Matricula;
    private String Nome;
    private String Cpf;
    private String Curso;

    public AlunoDTO(Aluno aluno) {
        Matricula = aluno.getMatricula();
        Nome = aluno.getNome();
        Cpf = aluno.getCpf();
        Curso = aluno.getCurso();
    }

    public Integer getMatricula() {
        return Matricula;
    }

    public String getNome() {
        return Nome;
    }

    public String getCpf() {
        return Cpf;
    }

    public String getCurso() {
        return Curso;
    }
}
