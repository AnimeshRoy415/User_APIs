package com.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer UserId;
	
	@NotNull(message = "Please type your name")
	private String name;
	
	@NotNull(message = "Please Enter Email")
	@Pattern(regexp = "^(.+)@(\\S+)$",message = "Input a valid email address")
	private String email;
	
	@NotNull(message = "Please Enter Your Date of Birth(MM/DD/YYYY)")
	@Pattern(regexp = "\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|[3][01])",message = "Input a valid date of birth")
	private String date_of_Birth;
	

	private Integer age;
	
	
	
	

}
