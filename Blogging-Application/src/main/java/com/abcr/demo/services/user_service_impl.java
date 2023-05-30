package com.abcr.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcr.demo.exception.ResourceNotFoundException;
import com.abcr.demo.pojo.User;
import com.abcr.demo.pojo.User;
import com.abcr.demo.repo.user_repo;

@Service
public class user_service_impl implements user_service {

	@Autowired
	private user_repo userrepo;

	@Override
	public User createuser(User user) {
		
		return this.userrepo.save(user);
		
	}

	@Override
	public List<User> getallusers() {
		
		return this.userrepo.findAll();
	}

	@Override
	public User updateUser(User user, Integer userId) {
		User found_user = this.userrepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("USer Not Found"));
		
		found_user.setEmail(user.getEmail());
		found_user.setName(user.getEmail());
		found_user.setPassword(user.getPassword());
		 
		User updated_user = this.userrepo.save(found_user);
	
	
		return updated_user;
		}
	

	@Override
	public void deleteuser(Integer userId) {
		
		System.out.println(userId);
		User found_user = this.userrepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
		System.out.println(found_user);
		this.userrepo.delete(found_user);
		
	}

	@Override
	public User getUserById(int userId) {
		User found_user = this.userrepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		
		return found_user;
	}
	
	

}
