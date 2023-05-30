package com.abcr.demo.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CategoryId;
	
	@NotBlank
	private String CategoryTitle;
	
	private String CategoryDescription;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category( String categoryTitle, String categoryDescription) {
		super();
		
		CategoryTitle = categoryTitle;
		CategoryDescription = categoryDescription;
	}



	public String getCategoryTitle() {
		return CategoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		CategoryTitle = categoryTitle;
	}

	public String getCategoryDescription() {
		return CategoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		CategoryDescription = categoryDescription;
	}
	
	
}
