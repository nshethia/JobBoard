package com.csye6220.esdfinalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csye6220.esdfinalproject.dao.UserDAO;
import com.csye6220.esdfinalproject.model.User;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDAO;

	@Override
	public void addUser(User user) {
	userDAO.save(user);	
	}

	@Override
	public void updateUser(User user) {
		userDAO.update(user);	
	}

	@Override
	public void deleteUser(User user) {
		userDAO.delete(user);		
	}

	@Override
	public User getUserById(long id) {	
		return userDAO.getById(id);
	}

	@Override
	public User getUserByEmail(String email) {
		return userDAO.getByEmail(email);
	}

	@Override
	public void deleteUserById(long id) {
		userDAO.deleteById(id);		
	}

	@Override
	public List<User> getAllUsers() {		
		return userDAO.getAllUsers();
	}

}
