package org.example.zadania_lab1.repository;

import org.example.zadania_lab1.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
