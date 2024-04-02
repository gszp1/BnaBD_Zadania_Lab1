package org.example.zadania_lab1.repository;

import org.example.zadania_lab1.model.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository <Department, Long> {
}
