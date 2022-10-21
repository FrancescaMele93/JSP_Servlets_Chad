package com.luv2code.jsp.tagdemo;

public class Student {
	
	private String firstName;
	private String lastName;
	private boolean goldenCustomer;
	
	public Student(String firstName, String lastName, boolean goldenCustomer) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.goldenCustomer = goldenCustomer;
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

	public boolean isGoldenCustomer() {
		return goldenCustomer;
	}

	public void setGoldenCustomer(boolean goldenCustomer) {
		this.goldenCustomer = goldenCustomer;
	}

}
