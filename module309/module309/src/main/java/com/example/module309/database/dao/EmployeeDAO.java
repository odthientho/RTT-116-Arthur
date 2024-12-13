package com.example.module309.database.dao;

import com.example.module309.database.entity.Customer;
import com.example.module309.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where e.id = :employeeId")
    Employee findById(Integer employeeId);
}
