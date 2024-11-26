package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.UsrDtl;

public interface UserRepository extends JpaRepository<UsrDtl,Integer>{
	public boolean existsByEmail(String email);
	
	

}
