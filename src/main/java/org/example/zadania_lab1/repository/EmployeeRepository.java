package org.example.zadania_lab1.repository;

import org.example.zadania_lab1.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
