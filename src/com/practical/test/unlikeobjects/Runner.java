package com.practical.test.unlikeobjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Runner {
	public static void main(String[] args) {
		ArrayList<Common> al = new ArrayList<Common>();
		al.add(new Tree(6, "Mango"));
		al.add(new House(15, "Mannat"));
		al.add(new Tree(8, "apple"));
		al.add(new House(12, "abhiman"));

		Comparator<Common> cmp=new ObjectHeightComparator();
		Collections.sort(al,cmp);
		for (Common c : al) {
			System.out.println("height:" + c.height);
		}

	}
}
