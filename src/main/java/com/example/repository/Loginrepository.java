package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.UsrDtl;

public interface Loginrepository extends JpaRepository<UsrDtl,Integer>{
	
	
	public UsrDtl findByEmailAndPassword(String email,String password);

}
