package com.practical.test.unlikeobjects;

import java.util.Comparator;

public class ObjectHeightComparator implements Comparator<Common>{

	@Override
	public int compare(Common o1, Common o2) {
		Double d=new Double(o1.height);
		return d.compareTo(o2.height);
	}

}
