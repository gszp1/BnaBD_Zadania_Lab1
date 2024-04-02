package org.example.zadania_lab1;

import org.example.zadania_lab1.model.Department;
import org.example.zadania_lab1.model.Employee;
import org.example.zadania_lab1.repository.DepartmentRepository;
import org.example.zadania_lab1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@Component
public class RunAtStart {

    private final EmployeeRepository employeeRepository;

    private final DepartmentRepository departmentRepository;

    @Autowired
    public RunAtStart(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        super();
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Bean
    public CommandLineRunner runner(EmployeeRepository employeeRepository) {
        return args -> {

            Department department = getDepartment();
            departmentRepository.save(department);

            Iterable<Employee> employees = employeeRepository.findAll();
            employees.forEach(System.out::println);

            System.out.println("\nEmployees with last names starting with K:\n");
            Iterable<Employee> employeesWithLastNameStartingWithK = employeeRepository
                    .findAllByFirstLetterOfLastName('K');
            employeesWithLastNameStartingWithK.forEach(System.out::println);
        };
    }

    private Department getDepartment() {
        Department department = new Department("SoftwareDevelopment",
                "DepartmentDescription",
                new BigDecimal("100000.0"),
                LocalDate.of(1999, 12, 1)
        );
        Employee employee1 = new Employee(
                "Tomasz",
                "Nowak",
                new BigDecimal("4500.00"),
                LocalDate.of(2024, 3, 2),
                department
        );
        Employee employee2 = new Employee(
                "Jan",
                "Kowalski",
                new BigDecimal("3699.45"),
                LocalDate.of(2019, 12, 23),
                department
        );
        department.getEmployees().addAll(Arrays.asList(employee1, employee2));
        return department;
    }
}
