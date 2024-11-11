package com.microservice.department_service.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.microservice.department_service.model.Department;

@Repository
public class DepartmentRepository {
private List<Department> departments = new ArrayList<>();
	
	public Department addDepartment(Department dep) {
		departments.add(dep);
		return dep;
	}
	public Department findById(Long id) {
		return departments.stream()
                .filter(department ->
                        department.getId().equals(id))
                .findFirst()
                .orElseThrow();
	}
	
	public List<Department> findAll(){
		return departments;
	}

}
