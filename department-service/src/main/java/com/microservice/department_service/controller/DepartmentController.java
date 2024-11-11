package com.microservice.department_service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.department_service.client.EmployeeClient;
import com.microservice.department_service.model.Department;
import com.microservice.department_service.repository.DepartmentRepository;


@RestController
@RequestMapping("/department")
public class DepartmentController {

	
	private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);
	@Autowired
	private EmployeeClient empCli;
	
	@Autowired
	private DepartmentRepository repository;
	
	@PostMapping
	public Department add(@RequestBody Department dp) {
		log.info("addDepartment dp : "+dp);
		return repository.addDepartment(dp);
	}
	
	@GetMapping
	public List<Department> findAll() {
		log.info("findAll() : calling");
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Department findById(@PathVariable Long id ) {
		log.info("findById()  id :"+id);
		return repository.findById(id);
	}
	
	@GetMapping("/with-employees")
    public List<Department> findAllWithEmployees() {
        log.info("Department find");
        List<Department> departments
                = repository.findAll();
        log.info("got Departments");
        departments.forEach(department ->
                department.setEmploy(
                		empCli.findByDepartment(department.getId())));
        log.info("returning Department");
        return  departments;
    }
}
