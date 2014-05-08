package com.management.utils;

import java.util.Arrays;

public final class CheckEmail implements ProjectConstants {
	public static boolean invalid(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (Arrays.asList("$", "/", "\\", "%", "#", ">", "<", ":", "*", "=").contains("" + s.charAt(i))) {
				System.out.println(i);
				return true;
			}
		}
		return false;
	}
	
	public static String validateEmail(String email) {

		if (email == null || email.equals(""))
			return MSG_EMPTY_EMAIL;
		if (email.contains("@"))
			return MSG_SUCCESS;
		return MSG_INVALID_EMAIL;
	}
}
