package com.abcr.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcr.demo.exception.ResourceNotFoundException;
import com.abcr.demo.pojo.Category;
import com.abcr.demo.repo.categ_repo;

@Service
public class categ_service_impl implements categ_service {

	@Autowired
	private categ_repo catrepo;
	
	
	@Override
	public Category createCategory(Category category) {
		System.out.println(category.getCategoryTitle());
		Category created = this.catrepo.save(category);
		return created;
	}

	@Override
	public Category updateCategory(Category category, Integer catId) {
		Category found = this.catrepo.findById(catId).orElseThrow(() -> new ResourceNotFoundException("Category Not Found"));
		
		found.setCategoryTitle(category.getCategoryTitle());
		found.setCategoryDescription(category.getCategoryDescription());
		
		return this.catrepo.save(found);
	}

	@Override
	public void deleteCategory(Integer catId) {
		Category found = this.catrepo.findById(catId).orElseThrow(() -> new ResourceNotFoundException("Category Not Found"));
		this.catrepo.delete(found);
	}

	@Override
	public Category getCategory(Integer catId) {
		
		return this.catrepo.findById(catId).orElseThrow(() -> new ResourceNotFoundException("Category Not Found"));
	}

	@Override
	public List<Category> getAllCategory() {
		
		return this.catrepo.findAll();
	}

}
