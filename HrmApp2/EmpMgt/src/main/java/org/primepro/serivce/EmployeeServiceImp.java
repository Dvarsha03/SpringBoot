package org.primepro.serivce;

import java.util.List;

import org.primepro.entity.Employee;
import org.primepro.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import org.primepro.exception.*;

@Service
public class EmployeeServiceImp implements EmployeeService {
	private EmployeeRepository employeeRepository;
	public EmployeeServiceImp(EmployeeRepository employeeRepository) {
		// TODO Auto-generated constructor stub
		super();
		this.employeeRepository = employeeRepository;
	}
	

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
		
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}


	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id", id));
		employeeRepository.deleteById(id);
		
	}

	@Override
	public Employee getEmpById(Long id) {
		// TODO Auto-generated method stub
	    return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","Id",id));
	
	}

	@Override
	public Employee updateEmployee(Employee employee, Long id) 
	{
		
		Employee existEmployee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employeee","Id",id));
		existEmployee.setFirstname(employee.getFirstname());
		existEmployee.setLastname(employee.getLastname());
		existEmployee.setEmailid(employee.getEmailid());
		employeeRepository.save(existEmployee);
		return existEmployee;
	}

}