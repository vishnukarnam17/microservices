package com.microservice.department_service.model;

import java.util.ArrayList;
import java.util.List;

public class Department {

	private Long id;
	private String name;
	List<Employee> employ = new ArrayList<>();
	
	public Department() {
		//super();
	}
	public Department(Long id, String name) {
		//super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", employ=" + employ + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getEmploy() {
		return employ;
	}
	public void setEmploy(List<Employee> employ) {
		this.employ = employ;
	}
	
}
