package leet_code;

import java.util.List;

public class ValidPalindromeV2 {

	public static void main(String[] args) {
		ValidPalindromeV2 validPalindromeV1 = new ValidPalindromeV2();
		List.of("A man, a plan, a canal: Panama", "race a car", " ")
			.forEach(it -> {
				boolean palindrome = validPalindromeV1.isPalindrome(it);
				System.out.println("isPalindrome? : " + palindrome);
			});
	}

	public boolean isPalindrome(String s) {
		final String lowerText = s.toLowerCase();
		final char[] charArray = lowerText.toCharArray();
		final StringBuilder sb = new StringBuilder();
		for (char c : charArray) {
			if (!Character.isLetterOrDigit(c) || c == ' ') {
				continue;
			}
			sb.append(c);
		}
		String removedText = sb.toString();
		String reversedText = sb.reverse().toString();

		return removedText.equals(reversedText);
	}
}
