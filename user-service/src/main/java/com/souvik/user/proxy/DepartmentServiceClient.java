package com.souvik.user.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.souvik.user.vo.Department;

//@FeignClient(name="department-service",url="http://localhost:9001")
@FeignClient(name="department-service")
public interface DepartmentServiceClient {

	@GetMapping("/departments/{id}")
	public Department findDepartmentById(@PathVariable("id") Long departmentId);
}
