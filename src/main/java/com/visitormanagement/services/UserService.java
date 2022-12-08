package com.visitormanagement.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visitormanagement.model.User;
import com.visitormanagement.model.Visitor;
import com.visitormanagement.repository.UserRepository;

@Service
public class UserService implements IUserService{
		
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<User> listAll() {
		List<User> userList = userRepo.findAll();
		
		return userList;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
	}
	@Override
	public User findByUsername(String username) {
		for (User user: userRepo.findAll()) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
	
	@Override
	public boolean validateLogin(String username, String password, String role) {
		
		User user = new User();
		for (User b: listAll()) {
			
			if (b.getUsername().equals(username) && b.getPassword().equals(password) && b.getRole().equals(role)) {
				return  true;
			}
		}
		return false;
		

	}
	
	@Override
	public void updateUser(User user) {
		userRepo.save(user);
	}
}

