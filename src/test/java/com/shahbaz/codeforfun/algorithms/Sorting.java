package com.shahbaz.codeforfun.algorithms;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * The story of Comparable and Comparator
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
	 * Sorting a string is possible only because it implements the Comparable
	 * interface or else we would have got a class cast exception.
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

}
