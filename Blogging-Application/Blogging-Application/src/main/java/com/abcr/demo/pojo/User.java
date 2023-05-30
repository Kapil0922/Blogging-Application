package com.abcr.demo.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
//@ComponentScan(basePackageClasses = {"com.abcr.demo.controller"})
public class User {
	
	public User() {
		
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
  
	@NotEmpty
	private String name;
	
	@Email(message = " Email is Not Valid ")
	private String email;
	

	@NotEmpty(message = " Password Cannot be Empty ")
	@Size(min = 6 , max = 10 , message = " Password must be between 6 to 10 characters !!!!! ")
	private String password;
	
	
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User(int id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	
}
