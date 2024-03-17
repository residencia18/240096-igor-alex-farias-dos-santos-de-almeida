package org.controle_empregado_projeto.controle_empregado_projeto.repository;

import org.controle_empregado_projeto.controle_empregado_projeto.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
