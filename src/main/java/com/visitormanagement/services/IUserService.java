package com.visitormanagement.services;

import java.util.Date;

import java.util.List;
import java.util.Optional;

import com.visitormanagement.model.User;
import com.visitormanagement.model.Visitor;

public interface IUserService {
	public List<User> listAll();
	
	public void save(User user) ;
	
	public User findByUsername(String username);	
	
	public void updateUser(User user);
	
	
	public boolean validateLogin (String username, String password, String role);

}