package com.practical.test.likeobjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BoquetShop {
	public static void main(String[] args) {
		ArrayList<Flower> al = new ArrayList<Flower>();
		al.add(new Flower(20, "rose"));
		al.add(new Flower(50, "orchids"));
		al.add(new Flower(50, "lotus"));

		Comparator<Flower> comparator = null;
		comparator = new FlowerNameComparator();// this technique is easy when
												// comparison needs to be done
												// based on multiple states
		// comparator=new FlowerPriceComparator();
		Collections.sort(al, comparator);
		for (Flower f : al) {
			System.out.println("flower name:" + f.name);

		}

	}
}
