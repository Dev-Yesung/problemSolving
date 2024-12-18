package leet_code;

import java.util.Arrays;

public class ReverseStringV1 {

	public static void main(String[] args) {
		char[] input = {'a', 'b', 'c', 'd', 'e', 'f'};
		char[] origin = Arrays.copyOf(input, input.length);
		new ReverseStringV1()
			.reverseString(input);
		System.out.println(Arrays.toString(origin));
		System.out.println(Arrays.toString(input));
	}

	public void reverseString(char[] s) {
		int startPointer = 0;
		int endPointer = s.length - 1;
		while (startPointer < endPointer) {
			char endChar = s[endPointer];
			char tmp = s[startPointer];
			s[endPointer] = tmp;
			s[startPointer] = endChar;

			startPointer++;
			endPointer--;
		}
	}
}
