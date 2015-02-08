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

	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
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

	public boolean equals(Object obj) {

		if (obj instanceof Employee) {
			Employee emp = (Employee) obj;
			if (this.id == emp.getId()
					&& this.name.compareTo(emp.getName()) == 0) {
				return true;
			}
		}
		return false;

	}
}
