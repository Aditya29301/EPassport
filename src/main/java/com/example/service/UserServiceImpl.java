package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.UsrDtl;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	@Override
	public UsrDtl createUser(UsrDtl user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}
	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.existsByEmail(email);
	}
	
	@Override
	public UsrDtl findUserById(int loginid) {
		
		return userRepo.findById(loginid).get();
	}
	
	

}
