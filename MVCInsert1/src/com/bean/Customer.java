package com.bean;

import java.util.Date;

public class Customer {
	private String firstName;
	private String lastName;
	private Date dob;
	private String gender;
	private String city;
	private String country;
	private String email;
	private double annual_salary;
	//getter and setter
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getAnnual_salary() {
		return annual_salary;
	}
	public void setAnnual_salary(double annual_salary) {
		this.annual_salary = annual_salary;
	}
	public Customer(String firstName, String lastName, Date dob, String gender, String city, String country,
			String email, double annual_salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.city = city;
		this.country = country;
		this.email = email;
		this.annual_salary = annual_salary;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	

}
