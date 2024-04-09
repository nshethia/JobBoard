package com.csye6220.esdfinalproject.model;
import jakarta.persistence.*;



@Entity
@Table
public class Company {

	public Company() {
		
	}
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@jakarta.persistence.Column(name = "id")
	private int id;
	private String CompanyName;
	private String password;
	private String CompanyEmail;
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		this.CompanyName = companyName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCompanyEmail() {
		return CompanyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.CompanyEmail = companyEmail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
