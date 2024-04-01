import java.util.Stack;

public class Programmers12909_1 {

	boolean solution(String s) {
		Stack<Character> stack = new Stack<>();
		for (char paren : s.toCharArray()) {
			if (paren == '(') {
				stack.add(paren);
				continue;
			}

			if (stack.isEmpty()) {
				return false;
			}

			stack.pop();
		}

		return stack.isEmpty() ? true : false;
	}

}
