package com.shahbaz.codeforfun.algorithms;

import java.util.Comparator;

/**
 * Sorting based on name
 * @author Shahbaz.Khan
 *
 */
public class EmployeeComparatorOnName implements Comparator<Employee> {

	/**
	 * returns positive if o1.name is lexicographically in higher than o2.name
	 * negative if lesser and zero if equals
	 */
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
