package com.abcr.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abcr.demo.pojo.ApiResponse;
import com.abcr.demo.pojo.User;
import com.abcr.demo.repo.user_repo;
import com.abcr.demo.services.user_service;

@RestController
@RequestMapping("/api/users")
public class User_Controller {
	
	@Autowired
	private user_service userservice; 
	


	@GetMapping
	public ResponseEntity<List<User>> getallusers() {
		return ResponseEntity.ok(this.userservice.getallusers());
	}
	
	@PostMapping("/create")
	public ResponseEntity<User> createuser(@RequestBody User user){
		System.out.println(user);
		User created_user = this.userservice.createuser(user);
		return new ResponseEntity<>(created_user , HttpStatus.CREATED );
		
	}
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<User> updateuser(@RequestBody User user , @PathVariable Integer userId){
		User updated_user = this.userservice.updateUser(user , userId);
		return ResponseEntity.ok(updated_user);
		
	}
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<?> deleteuser(@PathVariable Integer userId) {
		this.userservice.deleteuser(userId);
		
		return new ResponseEntity(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable int userId){
		
		return ResponseEntity.ok(this.userservice.getUserById(userId));
	}
	

	
}
