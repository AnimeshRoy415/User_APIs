package com.user.service;

import com.user.Excption.UserAlreadyExists;
import com.user.model.User;
import com.user.model.UserDTO;
import com.user.repository.UserDao;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserDao uDao;
	
	
	@Override
	public User saveUer(User user) {		
		User getUser = uDao.findByEmail(user.getEmail());
		LocalDate curDate = LocalDate.now();
		
		
		System.out.println(curDate);
		
		LocalDate dob = LocalDate.parse(user.getDate_of_Birth()); 
		
		if (getUser==null && dob != null && curDate != null ) {
			
			int calculatedAge= Period.between(dob, curDate).getYears();
			user.setAge(calculatedAge);
			
			
			return uDao.save(user);
		}
		else 
			throw new UserAlreadyExists("User Already Exists");
		
	}


	@Override
	public List<User> getAllUser(Integer pageNo, Integer pageSize) {
		
		
		Pageable pageable= PageRequest.of(pageNo, pageSize);
		
		Page<User> getPage= uDao.findAll(pageable);
		
		List<User> getpagableUser= getPage.getContent();
		
		return getpagableUser;
		
	}


	@Override
	public List<UserDTO> getAllUserByAge(Integer age) {
		
		List<User> userList= uDao.getUserByAge(age);
		
		List<UserDTO> userDTOs= new ArrayList<>();
		
		for(User u:userList) {
			
			String Name= u.getName();
			Integer getAge= u.getAge();
			
			UserDTO usersDTO= new UserDTO(Name, getAge);
			userDTOs.add(usersDTO);
			
		}
		
		
		return userDTOs;
	}


}
