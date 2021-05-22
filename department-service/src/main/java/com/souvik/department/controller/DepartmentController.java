package com.souvik.department.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.souvik.department.entity.Department;
import com.souvik.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	Environment environment;
	
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department){
		log.info("inside saveDepartment departmentController");
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("{id}")
	public Department findDepartmentById(@PathVariable("id") Long departmentId){
		log.info("inside findDepartmentById departmentController" + environment.getProperty("local.server.port"));
		return departmentService.findDepartmentById(departmentId);
				
	}
}
