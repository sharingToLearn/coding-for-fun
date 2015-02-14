package com.shahbaz.codeforfun.algorithms;

/**
 * Class to be sorted based on salary and name
 * 
 * @author Shahbaz.Khan
 *
 */
public class Employee {

	private int id;

	private String name;
	
	private double salary;

	public Employee(String name, int id,double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	

	
}
