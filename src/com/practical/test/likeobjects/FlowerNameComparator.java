package com.practical.test.likeobjects;

import java.util.Comparator;

public class FlowerNameComparator implements Comparator<Flower>{

	@Override
	public int compare(Flower o1, Flower o2) {
		return o1.name.compareTo(o2.name);
	}

}
