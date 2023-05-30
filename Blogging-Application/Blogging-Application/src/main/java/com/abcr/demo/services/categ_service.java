package com.abcr.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abcr.demo.pojo.Category;


public interface categ_service {

	Category createCategory(Category category);
	
	Category updateCategory(Category category , Integer catId);
	
	public void deleteCategory(Integer catId);
	
	public Category getCategory(Integer catId);
	
	public List<Category> getAllCategory();
}
