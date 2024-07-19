package programmers;

import java.util.*;
import java.util.stream.*;

public class Programmers42883 {
	public String solution(String number, int k) {
		Deque<Character> stack = new ArrayDeque<>();
		for (char c : number.toCharArray()) {
			while (k > 0 && !stack.isEmpty() && c > stack.peek()) {
				stack.pop();
				k--;
			}
			stack.push(c);
		}

		while (k > 0) {
			stack.pop();
			k--;
		}

		return new StringBuilder(stack.stream()
			.map(String::valueOf)
			.collect(Collectors.joining()))
			.reverse()
			.toString();
	}
}
