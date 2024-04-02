package org.example.zadania_lab1.repository;

import org.example.zadania_lab1.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.lastName LIKE ?1%")
    Iterable<Employee> findAllByFirstLetterOfLastName(char letter);
}
