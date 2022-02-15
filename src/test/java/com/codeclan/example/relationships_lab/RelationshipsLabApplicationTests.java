package com.codeclan.example.relationships_lab;

import com.codeclan.example.relationships_lab.models.Department;
import com.codeclan.example.relationships_lab.models.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.codeclan.example.relationships_lab.repositories.DepartmentRepository;
import com.codeclan.example.relationships_lab.repositories.EmployeeRepository;

@SpringBootTest
class RelationshipsLabApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;


	@Test
	void contextLoads() {
	}

	@Test
	public void createEmployeeAndDepartment() {
		Department department = new Department("Department A");
		departmentRepository.save(department);

		Employee employee1 = new Employee("John", "Smith", 345654, department);
		employeeRepository.save(employee1);
	}



}
