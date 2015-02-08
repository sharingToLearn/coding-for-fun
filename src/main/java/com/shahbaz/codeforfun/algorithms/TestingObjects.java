package com.shahbaz.codeforfun.algorithms;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

/**
 * Need to find a better ClassName
 * 
 * @author Shahbaz.Khan
 *
 */
public class TestingObjects extends Assert {

	public static void assertTrue(List<?> lExpected, List<?> lOriginal,
			String ignoredAttributes) {

		if (lOriginal.size() != lExpected.size()) {
			fail("Size of the two list is different");
		}

		List<Method> methods = new ArrayList<Method>();
		/* Iterating over two list to compare individual objects */
		for (int i = 0; i < lExpected.size(); i++) {

			if (methods.size() == 0) {
				methods = getGetterMehods(lExpected.get(i).getClass(),
						ignoredAttributes);
			}

			for (Method method : methods) {

				try {
					Object lExpectedObject = method.invoke(lExpected.get(i));
					Object lOrginalObject = method.invoke(lOriginal.get(i));

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

	public static List<Method> getGetterMehods(Class<? extends Object> clazz,
			String ignoredAttributes) {

		List<Method> lMethods = new ArrayList<Method>();
		for (Method method : clazz.getMethods()) {
			if (method.getName().startsWith("get")
					&& !method.getName().equalsIgnoreCase("get"+ignoredAttributes)) {
				lMethods.add(method);
			}
		}

		return lMethods;

	}
}
