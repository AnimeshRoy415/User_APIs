package com.user.repository;

import com.user.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
	public User findByEmail(String email);
	
	@Query("select u from User u where u.age>=?1")
	public List<User> getUserByAge(Integer age);
	

}
