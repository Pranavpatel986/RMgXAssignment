package com.rgmx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgmx.Repository.EmployeeRepo;
import com.rgmx.entity.Employee;
import com.rgmx.exception.ResourceNotFoundException;
import com.rgmx.model.EmployeeModel;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepo repo;
	
	public List<Employee> emp_list(){
		return repo.findAll();
	}
	
	public void saveEmp(EmployeeModel employeemodel) {
		Employee employee=new Employee(employeemodel.getFullName(), employeemodel.getDesignation());
		repo.save(employee);
	}
	public Employee findEmpById(Long id) {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
	}
}
