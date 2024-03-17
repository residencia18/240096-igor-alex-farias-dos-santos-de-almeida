package org.controle_empregado_projeto.controle_empregado_projeto.repository;

import org.controle_empregado_projeto.controle_empregado_projeto.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
