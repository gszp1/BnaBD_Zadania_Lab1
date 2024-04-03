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
    public CommandLineRunner runner(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        return args -> {

            // Create departments with employees.

            Department department = getFirstDepartment();
            departmentRepository.save(department);

            Department department2 = getSecondDepartment();
            departmentRepository.save(department2);

            // Read data inserted into table.

            System.out.println("\nAll employees:");
            Iterable<Employee> employees = employeeRepository.findAll();
            employees.forEach(System.out::println);

            System.out.println("\nEmployees with last names starting with K:");
            Iterable<Employee> employeesWithLastNameStartingWithK = employeeRepository
                    .findAllByFirstLetterOfLastName('K');
            employeesWithLastNameStartingWithK.forEach(System.out::println);

            System.out.println("\nEmployees that work in DataAnalysis department:");
            Iterable<Employee> employeesByDepartment = employeeRepository
                    .findAllByDepartmentName(department2.getName());
            employeesByDepartment.forEach(System.out::println);

            // Update Employees salaries and second department name.


            // Remove second department and employees from first one.
        };
    }

    private Department getFirstDepartment() {
        Department department = new Department(
                "SoftwareDevelopment",
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

    private Department getSecondDepartment() {
        Department department = new Department(
                "DataAnalysis",
                "DepartmentDescription",
                new BigDecimal("200000"),
                LocalDate.of(2001, 1, 12)
        );
        Employee employee1 = new Employee(
                "Jakub",
                "Kowalski",
                new BigDecimal("7000.4"),
                LocalDate.of(2000, 7, 4),
                department
        );
        Employee employee2 = new Employee(
                "Andrzej",
                "Nowak",
                new BigDecimal("2132.2"),
                LocalDate.of(2012, 12, 12),
                department
        );
        department.getEmployees().addAll(Arrays.asList(employee1, employee2));
        return department;
    }
}
