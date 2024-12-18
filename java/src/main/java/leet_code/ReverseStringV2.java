package leet_code;

import java.util.Arrays;

public class ReverseStringV2 {

	public static void main(String[] args) {
		char[] input = {'a', 'b', 'c', 'd', 'e', 'f'};
		char[] origin = Arrays.copyOf(input, input.length);
		new ReverseStringV2()
			.reverseString(input);
		System.out.println(Arrays.toString(origin));
		System.out.println(Arrays.toString(input));
	}

	public void reverseString(char[] s) {
		final StringBuilder sb = new StringBuilder();
		for (int i = s.length - 1; i >= 0; i--) {
			sb.append(s[i]);
		}
		final char[] reverseCharArray = sb.toString().toCharArray();
		System.arraycopy(reverseCharArray, 0, s, 0, reverseCharArray.length);
	}
}
