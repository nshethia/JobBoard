package com.csye6220.esdfinalproject.dao;

import java.util.List;

import com.csye6220.esdfinalproject.model.User;

public interface UserDAO {
	
	public void save(User user);
    public User getById(Long id);
    public User getByEmail(String email);
    public List<User> getAllUsers();


}
