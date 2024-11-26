package com.example.service;

import com.example.model.UsrDtl;

public interface UserService {
	public UsrDtl createUser(UsrDtl user);
	public boolean checkEmail(String email);
	public UsrDtl findUserById(int loginid);

}
