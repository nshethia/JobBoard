package com.csye6220.esdfinalproject.service;

import java.util.List;

import com.csye6220.esdfinalproject.model.User;

public interface UserService {
	public void addUser(User user);

    public User getUserById(long id);

    public User getUserByEmail(String email);
    
    public List<User> getAllUsers();
	

}
