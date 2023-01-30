package com.user.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.model.UserDTO;
import com.user.service.UserService;

@RestController
@RequestMapping("user/")
public class UserController {
	
	@Autowired
	private UserService uService;
	
//	
	@PostMapping("save/")
	public ResponseEntity<User> saveUserController(@Valid @RequestBody User user) {
		User responseUser =  uService.saveUer(user);
		return new  ResponseEntity<User>(responseUser, HttpStatus.CREATED);
	}
	
	@GetMapping("findAllUsers/{pageSize}/")
	public ResponseEntity<List<User>> getUserController(@Valid @PathVariable Integer pageSize) {
		
		Integer pageNo = 0;
		
		List<User> responseUser =  uService.getAllUser(pageNo, pageSize);
		return new  ResponseEntity<List<User>>(responseUser, HttpStatus.FOUND);
	}
	
	@GetMapping("findUsers/{age}/")
	public ResponseEntity<List<UserDTO>> getUserByAgeController(@Valid @PathVariable Integer age) {
		
		
		List<UserDTO> responseUser =  uService.getAllUserByAge(age);
		return new  ResponseEntity<List<UserDTO>>(responseUser, HttpStatus.FOUND);
	}
	

}
