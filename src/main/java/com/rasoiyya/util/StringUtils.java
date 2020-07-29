package com.rasoiyya.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {

	public static boolean isNotEmptyStr(String value) {
		return value != null && value.trim().length() > 0;
	}
	
	public static boolean isEmptyStr(String value) {
		return value == null || value.isEmpty();
	}
	
	public static String dateToString(Date date) {
		String dateStr = "";
		try {
			if (date != null && !"".equals(date)) {
				Format format = new SimpleDateFormat("YYYY-MM-dd mm:hh:ss");
				return format.format(date);
			}
		} catch (Exception e ) {
			return dateStr;
		}
		
		return dateStr;
		
	}
}
