package com.shahbaz.codeforfun.algorithms;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.WordUtils;

import junit.framework.Assert;

/**
 * Need to find a better ClassName
 * 
 * @author Shahbaz.Khan
 *
 */
public class TestingObjects extends Assert {

	/**
	 * Matches two List<Objects> and ignore comparison on some attributes
	 * 
	 * @param lExpected
	 * @param lOriginal
	 * @param ignoredAttributes
	 */
	public static void assertTrue(List<?> lExpected, List<?> lOriginal,
			String ignoredAttributes) {

		if (lOriginal.size() != lExpected.size()) {
			fail("Size of the two list is different");
		}

		if (lOriginal.getClass() != lExpected.getClass()) {
			fail("Objects belong to different class");
		}

		List<Method> methods = new ArrayList<Method>();
		/* Iterating over two list to compare individual objects */
		for (int i = 0; i < lExpected.size(); i++) {

			if (methods.size() == 0) {
				methods = getGetterMehods(lExpected.get(i).getClass(),
						ignoredAttributes);
			}

			compareObjects(methods, lExpected.get(i), lOriginal.get(i));

		}

	}

	/**
	 * 
	 * @param lExpected
	 * @param lOriginal
	 */
	public static void assertTrue(List<?> lExpected, List<?> lOriginal) {

		if (lOriginal.size() != lExpected.size()) {
			fail("Size of the two list is different");
		}

		if (lOriginal.getClass() != lExpected.getClass()) {
			fail("Objects belong to different class");
		}

		List<Method> methods = new ArrayList<Method>();
		// Iterating over two list to compare individual objects
		for (int i = 0; i < lExpected.size(); i++) {

			if (methods.size() == 0) {
				// different method called to get all the methods of the class
				// starting from "get" except getClass
				methods = getAllGetterMethods(lExpected.get(i).getClass());
			}

			compareObjects(methods, lExpected.get(i), lOriginal.get(i));

		}

	}

	public static List<Method> getGetterMehods(Class<? extends Object> clazz,
			String ignoredAttributes) {

		List<Method> lMethods = new ArrayList<Method>();
		for (Method method : clazz.getMethods()) {

			// method null condition check to be added
			if (method.getName().startsWith("get")
					&& !method.getName().equalsIgnoreCase(
							"get" + ignoredAttributes)
					&& !("getClass".equals(method.getName()))) {
				lMethods.add(method);
			}
		}

		return lMethods;

	}

	public static List<Method> getAllGetterMethods(Class<? extends Object> clazz) {

		List<Method> lMethods = new ArrayList<Method>();
		for (Method method : clazz.getMethods()) {
			if (method.getName().startsWith("get")
					&& !("getClass".equals(method.getName()))) {
				lMethods.add(method);
			}
		}

		return lMethods;

	}

	/**
	 * 
	 * @param lExpected
	 * @param lOriginal
	 * @param selectedAttributes
	 */
	public static void assertTrue(List<?> lExpected, List<?> lOriginal,
			String[] selectedAttributes) {

		if (lOriginal.size() != lExpected.size()) {
			fail("Size of the two list is different");
		}

		if (lOriginal.getClass() != lExpected.getClass()) {
			fail("Objects belong to different class");
		}

		List<Method> methods = new ArrayList<Method>();
		// Iterating over two list to compare individual objects
		for (int i = 0; i < lExpected.size(); i++) {

			if (methods.size() == 0) {
				// different method called to get all the methods of the class
				// starting from "get" except getClass
				methods = getSelectedGetterMethods(lExpected.get(i).getClass(),
						selectedAttributes);
			}

			compareObjects(methods, lExpected.get(i), lOriginal.get(i));

		}
	}

	public static List<Method> getSelectedGetterMethods(
			Class<? extends Object> clazz, String[] selectedAttributes) {

		List<Method> lMethods = new ArrayList<Method>();
		List<String> capitalAttr = Arrays.asList(selectedAttributes);
		for (Method method : clazz.getMethods()) {
			for (String attr : capitalAttr) {
				// check for selected attributes and add it method list
				if (method.getName().startsWith("get")
						&& method.getName()
								.endsWith(WordUtils.capitalize(attr))
						&& !("getClass".equals(method.getName()))) {
					lMethods.add(method);
				}
			}

		}

		return lMethods;
	}

	public static void compareObjects(List<Method> methods, Object lExpObject,
			Object lOrgObject) {
		for (Method method : methods) {

			try {
				Object lExpectedObject = method.invoke(lExpObject);
				Object lOrginalObject = method.invoke(lOrgObject);

				if (!lExpectedObject.equals(lOrginalObject)) {
					fail("Not Similar");
				}

			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}

}
