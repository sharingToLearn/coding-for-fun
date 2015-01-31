package com.shahbaz.code.genarator.code_engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {

	public static void main(String[] args) {

		String eqn = "2-1+2+61*9+3*1";
		splitSimpleOperation(eqn, "\\*");

	}

	public static String splitSimpleOperation(String str, String operator) {

		String tempArr[] = str.split(operator, 2);
		String lhs = tempArr[0];
		String rhs = tempArr[1];
		rhs = new StringBuffer(rhs).reverse().toString();

		lhs = getOperator(lhs);
		rhs = getOperator(rhs);
		

		return lhs + operator + rhs;
	}

	/**
	 * 
	 * @param lList
	 * @param str
	 * @return
	 */
	public static String getOperator(String str) {

		List<Integer> lList = new ArrayList<Integer>();
		lList.add(str.lastIndexOf("+"));
		lList.add(str.lastIndexOf("/"));
		lList.add(str.lastIndexOf("-"));
		lList.add(str.lastIndexOf("*"));
		return str.substring(Collections.max(lList) + 1);
	}

}
