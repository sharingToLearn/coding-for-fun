package com.shahbaz.codeforfun.algorithms;

import java.util.List;

import junit.framework.Assert;

/**
 * Need to find a better ClassName
 * 
 * @author Shahbaz.Khan
 *
 */
public class TestingObjects extends Assert {

	public static void assertTrue(List<?> lExpected, List<?> lOriginal) {

		if (lOriginal.size() != lExpected.size()) {
			fail("Size of the two list is different");
		}

		/* Iterating over two list to compare individual objects */
		for (int i = 0; i < lExpected.size(); i++) {
			if (!lExpected.get(i).equals(lOriginal.get(i))) {
				fail("Objects not similar");
			}
		}

	}
}
