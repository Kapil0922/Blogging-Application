package com.abcr.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abcr.demo.pojo.Category;

public interface categ_repo extends JpaRepository<Category, Integer>{

}
