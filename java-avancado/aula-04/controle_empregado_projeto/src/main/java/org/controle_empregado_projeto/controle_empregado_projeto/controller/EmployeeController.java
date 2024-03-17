package org.controle_empregado_projeto.controle_empregado_projeto.controller;

import org.controle_empregado_projeto.controle_empregado_projeto.model.Employee;
import org.controle_empregado_projeto.controle_empregado_projeto.model.Project;
import org.controle_empregado_projeto.controle_empregado_projeto.repository.EmployeeRepository;
import org.controle_empregado_projeto.controle_empregado_projeto.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @PostMapping(value = "/createEmployee")
    public String createEmployee(@RequestBody Employee entity) {
        System.out.println("\nCreate a new Employee." + "\n");

        // create a new Employee
        Employee employee = new Employee(entity.getName(), entity.getEmail(),
                entity.getTechnicalSkill());

        // save Employee
        employee = employeeRepository.save(employee);
        System.out.println("\nSaved employee :: " + employee + "\n");

        return "Employee saved!!!";
    }

    @PostMapping(value = "/createEmployeeForProject/{projId}")
    public String createEmployeeForProject(@RequestBody Employee entity,
                                           @PathVariable(name = "projId") String projId) {
        System.out.println("\nCreate a new Employee and " +
                "assign to an existing Project." + "\n");

                // create a new Employee
                Employee employee = new Employee(entity.getName(), entity.getEmail(),
                        entity.getTechnicalSkill());

        // save Employee
        employee = employeeRepository.save(employee);
        System.out.println("\nSaved employee :: " + employee + "\n");

        // get a Project
        Project project = this.projectRepository.getById(Integer.valueOf(projId));
        System.out.println("\nProject details :: " + project.toString() + "\n");

        // create Employee set
        Set<Employee> employees = new HashSet<>();
        employees.add(employee);

        // assign Employee Set to Project
        project.setEmployees(employees);

        // save Project
        project = projectRepository.save(project);

        System.out.println("\nEmployee assigned to the Project." + "\n");

        return "Employee saved!!!";
    }

    @PostMapping(value = "/assignEmployeeToProject/{projId}")
    public String assignEmployeeToProject(@PathVariable(name = "projId") Integer projId) {
        System.out.println("\nFetch existing Employee details and assign " +
                "them to an existing Project." + "\n");

                // get first Employee
        int emplId = 1;
        Employee employee1 = this.employeeRepository.getById(emplId);
        System.out.println("\nEmployee details :: " + employee1.toString() + "\n");

        // get first Employee
        emplId = 8;
        Employee employee2 = this.employeeRepository.getById(emplId);
        System.out.println("\nEmployee details :: " + employee2.toString() + "\n");

        // get a Project
        Project project = this.projectRepository.getById(projId);
        System.out.println("\nProject details :: " + project.toString() + "\n");

        // create Employee set
        Set<Employee> employees = new HashSet<>();
        employees.add(employee1);
        employees.add(employee2);

        // assign Employee Set to Project
        project.setEmployees(employees);

        // save Project
        project = projectRepository.save(project);

        System.out.println("Employees assigned to the Project." + "\n");

        return "Employee saved!!!";
    }

    @GetMapping(value = "/getEmployee/{empId}")
    public String getEmployee(@PathVariable(name = "empId") Integer empId) {
        System.out.println("Fetch Employee and Project details.");

        // get Employee details
        Employee employee = this.employeeRepository.getById(empId);
        System.out.println("\nEmployee details :: " + employee.toString() + "\n");
        System.out.println("\nProject details :: " + employee.getProjects() + "\n");

        System.out.println("Done!!!" + "\n");

        return "Employee fetched successfully!!!";
    }

}
