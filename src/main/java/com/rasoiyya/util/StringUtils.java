package com.rasoiyya.util;

public class StringUtils {

	public static boolean isNotEmptyStr(String value) {
		return value != null && value.trim().length() > 0;
	}
	
	public static boolean isEmptyStr(String value) {
		return value == null || value.isEmpty();
	}
}
