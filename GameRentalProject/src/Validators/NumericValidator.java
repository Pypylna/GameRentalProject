package Validators;

import java.util.regex.Pattern;

public class NumericValidator {
	
	private static String amountPattern = "^\\d+([.,]\\d{1,2})?$";
	
	 public static boolean verifyAmount(String text) {
         boolean boo = Pattern.matches(amountPattern, text);
         return boo;
	    }
	
}
