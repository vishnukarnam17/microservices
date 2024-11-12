package com.microservice.employee_service.model;

public record Employee(Long id, Long roleId, String name, int age, String position) {

}
