package leet_code;

import java.util.List;

public class ValidPalindromeV1 {

	public static void main(String[] args) {
		ValidPalindromeV1 validPalindromeV1 = new ValidPalindromeV1();
		List.of("A man, a plan, a canal: Panama", "race a car", " ")
			.forEach(it -> {
				boolean palindrome = validPalindromeV1.isPalindrome(it);
				System.out.println("isPalindrome? : " + palindrome);
			});
	}

	public boolean isPalindrome(String s) {
		int forwardPointer = 0;
		int backwardPointer = s.length() - 1;
		final char[] charArray = s.toLowerCase().toCharArray();
		while (forwardPointer < backwardPointer) {
			final char forwardChar = charArray[forwardPointer];
			final char backwardChar = charArray[backwardPointer];
			if (!Character.isLetterOrDigit(forwardChar)) {
				forwardPointer++;
				continue;
			}
			if (!Character.isLetterOrDigit(backwardChar)) {
				backwardPointer--;
				continue;
			}

			if (forwardChar != backwardChar) {
				return false;
			}
			forwardPointer++;
			backwardPointer--;
		}

		return true;
	}
}
