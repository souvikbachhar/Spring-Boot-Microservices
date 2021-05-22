package com.souvik.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.souvik.user.entity.User;
import com.souvik.user.proxy.DepartmentServiceClient;
import com.souvik.user.repository.UserRepository;
import com.souvik.user.vo.Department;
import com.souvik.user.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DepartmentServiceClient dClient;

	public User saveUser(User user) {
		log.info("inside saveUser");
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("inside getUserWithDepartment");
		ResponseTemplateVO vo= new ResponseTemplateVO();
		User user= userRepository.findByUserId(userId);
		//Department department= restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
		Department department= dClient.findDepartmentById(userId);
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}

	public List<User> getUsers() {
		log.info("inside getUsers");
		return userRepository.findAll();
	}

	public User getUsersById(Long userId) {
		log.info("inside getUsersById");
		return userRepository.findByUserId(userId);
	}
}
