package com.project.utilities;

import java.util.Arrays;

public final class CheckEmail {
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
			return "empty_email";
		if (email.contains("@"))
			return "success";
		return "invalid_email";
	}
}
