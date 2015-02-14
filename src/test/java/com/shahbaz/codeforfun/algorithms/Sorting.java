package com.shahbaz.codeforfun.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * The story of <code>Comparable</code> and <code>Comparator<code>
 * 
 * @author Shahbaz.Khan
 *
 */
public class Sorting {

	/*
	 * Sorting array of ints
	 */

	@Test
	public void sortArrayOfInts() {
		final int[] numbers = { -3, -5, 1, 7, 4, -2 };
		final int[] expected = { -5, -3, -2, 1, 4, 7 };
		Arrays.sort(numbers);
		Assert.assertArrayEquals(expected, numbers);
	}

	/*
	 * Sorting a java.lang.String and java.lang.Integer is possible only because
	 * it implements the Comparable interface or else we would have got a class
	 * cast exception.
	 */

	@Test
	public void sortingArrayOfStrings() {
		final String[] orginal = { "shahbaz", "shabby", "shabbir", "test",
				"asset" };
		final String[] expected = { "asset", "shabbir", "shabby", "shahbaz",
				"test" };

		Arrays.sort(orginal);
		Assert.assertArrayEquals(expected, orginal);

	}

	/*
	 * Sorting a class which does not implement Comparable will always throw a
	 * ClassCastException
	 */
	@Test(expected = ClassCastException.class)
	public void sortingAnObjectWhichDoesNotImplementComparable() {
		List<NotComparable> lNoComparables = new ArrayList<NotComparable>();
		for (int i = 0; i < 10; i++) {
			lNoComparables.add(new NotComparable(i));
		}

		Arrays.sort(lNoComparables.toArray());

		// Collects.sort() will directly throw a compilation failure since it
		// does not implements Comparable
		// Collections.sort(lNoComparables);

	}

	/*
	 * Sorting works perfectly after implementing Comparable
	 */
	@Test
	public void sortingAnObjectWhichDoesImplementComparable() {

		List<ImplemetingComparable> lExpected = new ArrayList<ImplemetingComparable>();
		lExpected.add(new ImplemetingComparable(2));
		lExpected.add(new ImplemetingComparable(3));
		lExpected.add(new ImplemetingComparable(4));

		List<ImplemetingComparable> lComparables = new ArrayList<ImplemetingComparable>();
		lComparables.add(new ImplemetingComparable(4));
		lComparables.add(new ImplemetingComparable(3));
		lComparables.add(new ImplemetingComparable(2));
		Collections.sort(lComparables);

		/*
		 * Need to find a way to assert on List of objects
		 */

	}

	/*
	 * Sorting on name by using a comparator. NOTE: we have not touched the
	 * Employee. NOTE: we are passing a separate Comparator object which knows
	 * how to sort based on name.
	 */
	@Test
	public void sortingEmployeeOnName() {
		List<Employee> lExpected = new ArrayList<Employee>();
		lExpected.add(new Employee("asset", 5,5000));
		lExpected.add(new Employee("shabbir", 1,1000));
		lExpected.add(new Employee("shabby", 3,3000));
		lExpected.add(new Employee("shahbaz", 2,2000));
		lExpected.add(new Employee("test", 4,4000));

		List<Employee> lOriginal = new ArrayList<Employee>();
		lOriginal.add(new Employee("shahbaz", 2,2000));
		lOriginal.add(new Employee("shabby", 3,3000));
		lOriginal.add(new Employee("shabbir", 1,1000));
		lOriginal.add(new Employee("test", 4,4000));
		lOriginal.add(new Employee("asset", 5,5000));

		Collections.sort(lOriginal, new EmployeeComparatorOnName());

		TestingObjects.assertTrue(lExpected, lOriginal, "id");

		/*
		 * Need to find a way to assert on List of objects
		 */
	}

	/*
	 * Sorting on id by using a comparator. NOTE: we have not touched the
	 * Employee. NOTE: we are passing a separate Comparator object which knows
	 * how to sort based on id.
	 */
	@Test
	public void sortingEmployeeOnId() {
		List<Employee> lExpected = new ArrayList<Employee>();
		lExpected.add(new Employee("shabbir", 1,1000));
		lExpected.add(new Employee("shahbaz", 2,2000));
		lExpected.add(new Employee("shabby", 3,3000));
		lExpected.add(new Employee("test", 4,4000));
		lExpected.add(new Employee("asset", 5,5000));

		List<Employee> lOriginal = new ArrayList<Employee>();
		lOriginal.add(new Employee("shahbaz", 2,2000));
		lOriginal.add(new Employee("shabby", 3,300));
		lOriginal.add(new Employee("shabbir", 1,1000));
		lOriginal.add(new Employee("test", 4,4000));
		lOriginal.add(new Employee("asset", 5,5000));

		Collections.sort(lOriginal, new EmployeeComparatorOnId());
		String[] compareBasedOn={"id", "salary"};
		TestingObjects.assertTrue(lExpected, lOriginal, compareBasedOn);

		/*
		 * Need to find a way to assert on List of objects
		 */
	}

}
