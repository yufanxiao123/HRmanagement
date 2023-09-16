package net.javaguide.employeeservice.reposity;

import net.javaguide.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

   Optional<Employee> findByEmail(String email);
}
