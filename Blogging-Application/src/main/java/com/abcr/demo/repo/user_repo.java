package com.abcr.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abcr.demo.pojo.User;

public interface user_repo extends JpaRepository<User, Integer>{

}
