package leet_code;

import java.util.List;

public class ValidPalindromeV3 {

	public static void main(String[] args) {
		ValidPalindromeV3 validPalindromeV1 = new ValidPalindromeV3();
		List.of("A man, a plan, a canal: Panama", "race a car", " ")
			.forEach(it -> {
				boolean palindrome = validPalindromeV1.isPalindrome(it);
				System.out.println("isPalindrome? : " + palindrome);
			});
	}

	public boolean isPalindrome(String s) {
		final String lowerCaseText = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		final String reverseText = new StringBuilder(lowerCaseText).reverse().toString();

		return lowerCaseText.equals(reverseText);
	}
}
