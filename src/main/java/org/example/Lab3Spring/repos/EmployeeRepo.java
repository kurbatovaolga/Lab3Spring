package org.example.Lab3Spring.repos;

import org.example.Lab3Spring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface EmployeeRepo  extends JpaRepository<Employee, Long> {
    //List<Employee>findByLastName(String lastName);
}
