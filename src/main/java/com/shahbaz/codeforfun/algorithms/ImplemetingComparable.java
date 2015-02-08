package com.shahbaz.codeforfun.algorithms;

/**
 * Class implementing the <code>Comparable</code> interface so it has access to
 * the compareTo method wherein the logic of comparing can be written.
 * 
 * @author Shahbaz.Khan
 *
 */
public class ImplemetingComparable implements Comparable<ImplemetingComparable> {

	private int i;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public ImplemetingComparable(final int i) {
		this.i = i;
	}

	/**
	 * returns positive value if current objetc's 1 is greater than paramObj
	 * negative if lesser and zero if both are equal
	 */
	public int compareTo(ImplemetingComparable paramObj) {

 		int compareValeOfi = ((ImplemetingComparable) paramObj).getI();
		return this.i - compareValeOfi;

	}
	
	/*================= Disadvantages ========================
	 * 1. Will only sort based on one logic as there is only one
	 * compareTo() method.
	 * 
	 * 2. If Source code of the class is not available or if the
	 * class is final nothing can be done to make it or its
	 * sub classes implement comparable
	 * 
	 * 
	 *========================================================*/

}
