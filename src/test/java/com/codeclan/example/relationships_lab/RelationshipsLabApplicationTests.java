package com.codeclan.example.relationships_lab;

import com.codeclan.example.relationships_lab.models.Department;
import com.codeclan.example.relationships_lab.models.Employee;
import com.codeclan.example.relationships_lab.models.Project;
import com.codeclan.example.relationships_lab.repositories.ProjectRepository;
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

	@Autowired
	ProjectRepository projectRepository;


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

	@Test
	public void addEmployeesAndProjects(){
		Department department = new Department("Department A");
		departmentRepository.save(department);

		Employee employee1 = new Employee("John", "Smith", 345654, department);
		employeeRepository.save(employee1);

		Employee employee2 = new Employee("Peter", "Smith", 345654, department);
		employeeRepository.save(employee1);
		employeeRepository.save(employee2);

		Project project1 = new Project("Capstone", 9);
		project1.addEmployeeToProject(employee1);
		project1.addEmployeeToProject(employee2);
		projectRepository.save(project1);
	}



}
