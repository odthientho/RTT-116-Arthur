package com.example.module309.database.dao;

import com.example.module309.database.entity.Customer;
import com.example.module309.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where e.id = :employeeId")
    Employee findById(Integer employeeId);

//    @Query("select e from Employee e order by e.lastName limit 10")
//    List<Employee> findAllEmployee();

    @Query(value = "select * from employees order by lastname asc;", nativeQuery = true)
    List<Employee> findAllEmployees();
}
