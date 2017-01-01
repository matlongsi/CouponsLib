package com.coupon.common.utils;

public class ExceptionHelper {

	public static <T> T unrollException(
							Throwable exception,
							Class<T> expected) {

		while(exception != null && exception != exception.getCause()) {

			if(expected.isInstance(exception)){

				return expected.cast(exception);
			}
			exception = exception.getCause();
		}
		
		return null;
	}

}