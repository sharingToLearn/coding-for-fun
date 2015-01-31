package com.shahbaz.code.genarator.code_engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Function {

	public static String calculator(String str) {
		while (str.contains("(") || str.contains(")") || str.contains("+")
				|| str.contains("/") || str.contains("-") || str.contains("*")) {

			if (str.contains("(")) {

				String withinBraces = str.substring(str.indexOf("(") + 1,
						str.indexOf(")"));
				int x = Character.getNumericValue(withinBraces.charAt(0));
				int y = Character.getNumericValue(withinBraces.charAt(2));
				String operator = String.valueOf(withinBraces.charAt(1));
				str = simpleSolve(x, operator, y, str, true);
				System.out.println("After brackets " + str);

			} else if (str.contains("/")) {
				System.out.println(str);
				break;
			} else if (str.contains("*")) {
				String multipleOperation[] = splitSimpleOperation(str, "\\*")
						.split("\\*");

				int x = Integer.parseInt(multipleOperation[0]);
				int y = Integer.parseInt(multipleOperation[1]);
				String operator = "*";
				str = simpleSolve(x, operator, y, str, false);
				System.out.println("MUL : " + str);

			} else if (str.contains("+")) {

				String addOperation[] = splitSimpleOperation(str, "\\+").split(
						"\\+");

				int x = Integer.parseInt(addOperation[0]);
				int y = Integer.parseInt(addOperation[1]);
				String operator = "+";
				str = simpleSolve(x, operator, y, str, false);
				System.out.println("ADD " + str);
			}
		}

		return str;

	}

	/**
	 * 
	 * @param x
	 * @param operator
	 * @param y
	 * @param original
	 * @param hasBraces
	 * @return
	 */

	public static String simpleSolve(int x, String operator, int y,
			String original, boolean hasBraces) {

		int answer = 0;

		if (operator.equals("+")) {
			answer = x + y;
		} else if (operator.equals("-")) {
			answer = x - y;
		} else if (operator.equals("*")) {
			answer = x * y;
		} else {
			answer = x / y;
		}
		System.out.println(answer);
		String solved = "";
		if (hasBraces) {
			solved = "(" + x + operator + y + ")";
		} else {
			solved = x + operator + y;
		}

		return shortenString(solved, original, answer);
	}

	/**
	 * 
	 * @param solved
	 * @param original
	 * @param answer
	 * @return
	 */
	public static String shortenString(String solved, String original,
			int answer) {

		return original.replace(solved, new Integer(answer).toString());
	}

	/**
	 * 
	 * @param str
	 * @param operator
	 * @return
	 */
	public static String splitSimpleOperation(String str, String operator) {

		String tempArr[] = str.split(operator, 2);
		String lhs = tempArr[0];
		String rhs = tempArr[1];
		rhs = new StringBuffer(rhs).reverse().toString();

		lhs = getOperator(lhs);
		rhs = getOperator(rhs);
		return lhs + operator.replace("\\", "") + rhs;
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

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Function.calculator("6*(4/2)+(6+2)+3*1*3");

	}
}
