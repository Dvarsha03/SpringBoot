package org.primepro.serivce;

import java.util.List;

import org.primepro.entity.Employee;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmpById(Long id);
    Employee updateEmployee(Employee employee,Long id);
    void deleteEmployee(Long id);
    
}
