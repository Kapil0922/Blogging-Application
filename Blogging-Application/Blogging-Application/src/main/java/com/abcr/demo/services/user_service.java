package com.abcr.demo.services;

import java.util.List;

import com.abcr.demo.pojo.User;
import com.abcr.demo.pojo.User;

public interface user_service {

	List<User> getallusers();
	
	User createuser(User user);
	
	User updateUser(User user , Integer userId);
	
	void deleteuser(Integer userId);
	
	User getUserById(int userId);
	

}
