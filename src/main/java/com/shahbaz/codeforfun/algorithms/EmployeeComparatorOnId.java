package com.shahbaz.codeforfun.algorithms;

import java.util.Comparator;

public class EmployeeComparatorOnId implements Comparator<Employee> {

	public int compare(Employee o1, Employee o2) {

		return o1.getId() - o2.getId();
	}

}
