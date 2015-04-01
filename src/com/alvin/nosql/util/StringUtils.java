package com.alvin.nosql.util;

public final class StringUtils {

	private StringUtils() {
	}

	public static boolean isNullorEmpty(String obj) {
		return (obj == null) || (obj.trim().equals(""));
	}
}
