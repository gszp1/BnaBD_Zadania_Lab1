package org.example.zadania_lab1.repository;

import org.example.zadania_lab1.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.lastName LIKE ?1%")
    Iterable<Employee> findAllByFirstLetterOfLastName(char letter);

    Iterable<Employee> findAllByDepartmentName(String departmentName);

    Optional<Employee> findFirstByDepartmentName(String departmentName);
}
