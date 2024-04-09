package com.csye6220.esdfinalproject.model;


import jakarta.persistence.*;
import jakarta.persistence.Column;
import java.util.*;

@Entity
@Table
public class User {

	
	@Override
	public String toString() {
		return "User [id=" + id + "password=" + password + ", email=" + email + "]";
	}
	public User() {
		
	}
	
	
	public User(String email, String password){
		this.email=email;
		this.password=password;
		
	}
	
	@Id
	@GeneratedValue
	@Column(name="UserId")
	private int id;
	
	@Column
	private String password;
	@Column
	private String email;
	
	@ManyToMany(mappedBy="users",fetch = FetchType.EAGER)
	private Set<ApplyJob> applyJobs= new HashSet<>();
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Set<ApplyJob> getApplyJobs() {
		return applyJobs;
	}
	public void setApplyJobs(Set<ApplyJob> applyJobs) {
		this.applyJobs = applyJobs;
	}


}
