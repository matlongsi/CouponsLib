package com.coupon.common.utils;

public class ValidatorHelper {

    public static Byte computeCheckDigit(Long ... numbers) {
    	
	    	int checkNumber = 0;
	    	for (Long number : numbers) {
	    		
	    		//compute and add check digit for each number using digital root
	    		checkNumber += number - 9 * ((number - 1) / 9);
	    	}
	
	    	//compute check digit for sum of individual check digits using digital root
	    	Byte checkDigit = (byte)(checkNumber - 9 * ((checkNumber - 1) / 9));
	    	
	    	return checkDigit;
    }

}
