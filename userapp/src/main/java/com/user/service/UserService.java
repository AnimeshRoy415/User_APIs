package com.user.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.user.model.User;
import com.user.model.UserDTO;

public interface UserService {
	
	public User saveUer(User user);
	
	public List<User> getAllUser(Integer pageNo, Integer pageSize);
	
	
	public List<UserDTO> getAllUserByAge(Integer age);

}
