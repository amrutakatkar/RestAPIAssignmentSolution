package com.glearning.SpringAssignmentSolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glearning.SpringAssignmentSolution.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
