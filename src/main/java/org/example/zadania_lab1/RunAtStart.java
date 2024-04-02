package org.example.zadania_lab1;

import org.example.zadania_lab1.model.Employee;
import org.example.zadania_lab1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class RunAtStart {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public RunAtStart(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Bean
    public CommandLineRunner runner(EmployeeRepository employeeRepository) {
        return args -> {
            employeeRepository.save(new Employee("Tomasz", "Nowak", new BigDecimal("4500.00")));
            employeeRepository.save(new Employee("Jan", "Kowalski", new BigDecimal("3699.45")));
        };
    }
}
