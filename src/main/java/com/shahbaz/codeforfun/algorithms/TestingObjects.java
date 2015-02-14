package com.shahbaz.codeforfun.algorithms;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
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

	
	public static void assertTrue(List<?> lExpected, List<?> lOriginal)
	{
		
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
				// different method called to get all the methods of the class starting from "get" except getClass
				methods = getAllGetterMethods(lExpected.get(i).getClass());
			}

			for (Method method : methods) {

				try {
					Object lExpectedObject = method.invoke(lExpected.get(i));
					Object lOrginalObject = method.invoke(lOriginal.get(i));

					if (!lExpectedObject.equals(lOrginalObject)) {
						fail("All attributes of the class are not same");
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
			
			//method null condition check to be added
			if (method.getName().startsWith("get")
					&& !method.getName().equalsIgnoreCase("get"+ignoredAttributes) && !("getClass".equals(method.getName()))) {
				lMethods.add(method);
			}
		}

		return lMethods;

	}
	
	public static List<Method> getAllGetterMethods(Class<? extends Object> clazz) {

		List<Method> lMethods = new ArrayList<Method>();
		for (Method method : clazz.getMethods()) {
			if (method.getName().startsWith("get") && !("getClass".equals(method.getName()))) {
				lMethods.add(method);
			}
		}

		return lMethods;

	}
	
	
	
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
				// different method called to get all the methods of the class starting from "get" except getClass
				methods = getSelectedGetterMethods(lExpected.get(i).getClass(),selectedAttributes);
			}

			for (Method method : methods) {

				try {
					Object lExpectedObject = method.invoke(lExpected.get(i));
					Object lOrginalObject = method.invoke(lOriginal.get(i));

					if (!lExpectedObject.equals(lOrginalObject)) {
						fail("Selected attributes of the class are not equal");
					}

				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					e.printStackTrace();
				}
			}

		}
	}
	
	
	public static List<Method> getSelectedGetterMethods(Class<? extends Object> clazz,String[] selectedAttributes) {

		List<Method> lMethods = new ArrayList<Method>();
		List<String> capitalAttr=getCapitalized(selectedAttributes);
		for (Method method : clazz.getMethods()) {
			for(String attr:capitalAttr)
			{
				//check for selected attributes and add it method list
				if (method.getName().startsWith("get") &&  method.getName().endsWith(attr) && !("getClass".equals(method.getName()))) {
					lMethods.add(method);
				}
			}
			
		}

		return lMethods;

	}
	//To convert first letter of word to uppercase
	private static List<String> getCapitalized(String[] selectedAttributes)
	{
		List<String> capitalAttr=new ArrayList<String>();
		for(int i=0;i<selectedAttributes.length;i++)
		{
			capitalAttr.add(WordUtils.capitalize(selectedAttributes[i]));
		}
		return capitalAttr;
	}
	
}
