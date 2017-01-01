package com.coupon.common.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ListCompare {

	public static <T extends Comparable<T>> boolean equal(List<? extends T> leftParam, List<? extends T> rightParam) {

		if ((leftParam == null) || (rightParam == null)) {	    	
			return (leftParam == rightParam);
		}
		
		if (leftParam.size() != rightParam.size()) {	    		
			return false;
		}
		
		List<T> leftList = new ArrayList<T>(leftParam);
		Collections.sort(leftList);
		List<T> rightList = new ArrayList<T>(rightParam);
		Collections.sort(rightList);
		
		return leftList.equals(rightList);
	}

}