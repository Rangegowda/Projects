package com.ibm.train.bean;

public class Passenger {
	private String name;
	private int age;
	private String gender;
	private double fare;
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Passenger(String name, int age, String gender,double fare) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.fare = fare;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	@Override
	public String toString() {
		return "Passenger [name=" + name + ", age=" + age + ", gender=" + gender + ", fare=" + fare + "]";
	}
	
	
	}

