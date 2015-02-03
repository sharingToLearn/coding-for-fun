package com.practical.test.likeobjects;

import java.util.Comparator;

public class FlowerPriceComparator implements Comparator<Flower> {

	@Override
	public int compare(Flower o1, Flower o2) {
		Double d = new Double(o1.price);
		return d.compareTo(o2.price);
	}

}
