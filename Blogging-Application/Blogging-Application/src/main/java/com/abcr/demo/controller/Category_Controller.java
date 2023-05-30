package com.abcr.demo.controller;

import java.util.List;

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
import com.abcr.demo.pojo.Category;
import com.abcr.demo.services.categ_service;

@RestController
@RequestMapping("/api/category")
public class Category_Controller {

	@Autowired
	private categ_service catService;
	
	
	@PostMapping("/create")
	public ResponseEntity<Category> createCategory(@RequestBody Category category){
		
		System.out.println(category.getCategoryTitle());
		Category created = this.catService.createCategory(category);
		
		return new ResponseEntity<>(created , HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{catId}")
	public ResponseEntity<Category> updateCategory(@RequestBody Category  category , @PathVariable Integer catId){
		Category updated = this.catService.updateCategory(category, catId);
		
		return new ResponseEntity<Category>(updated,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{catId}")
	public ResponseEntity<?> deleteCategory(@PathVariable Integer catId){
		this.catService.deleteCategory(catId);
		
		return new ResponseEntity(new ApiResponse("Category Deleted Successfully" , true),HttpStatus.OK);
	}
	
	@GetMapping("/{catId}")
	public ResponseEntity<Category> getCategory(@PathVariable Integer catId){
		Category found = this.catService.getCategory(catId);
		return new ResponseEntity<Category>(found,HttpStatus.OK);
	}
	
	@GetMapping
	public List<Category> getAllCategory(){
		
		return this.catService.getAllCategory();
	}
}
