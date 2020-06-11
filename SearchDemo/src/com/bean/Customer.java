package com.bean;

import java.util.ArrayList;

public class Customer {
	private int  customerId;
	private String firstName;
	private String lastName;
	private String contact;
	private String gender;
	private String married;
	private String city;
	private ArrayList<Hobby> hobbyList;
	//getter and setter
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
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
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMarried() {
		return married;
	}
	public void setMarried(String married) {
		this.married = married;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public ArrayList<Hobby> getHobbyList() {
		return hobbyList;
	}
	public void setHobbyList(ArrayList<Hobby> hobbyList) {
		this.hobbyList = hobbyList;
	}
	public Customer(int customerId, String firstName, String lastName, String contact, String gender, String married,
			String city, ArrayList<Hobby> hobbyList) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.gender = gender;
		this.married = married;
		this.city = city;
		this.hobbyList = hobbyList;
	}
	public Customer() {
		super();
	}
	
	
}
