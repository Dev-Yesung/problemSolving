import java.util.*;


// https://school.programmers.co.kr/learn/courses/30/lessons/76502
public class Programmers76502_1 {

	public int solution(String str) {
		int answer = 0;
		Queue<Character> q = new LinkedList<>();
		for (char c : str.toCharArray()) {
			q.offer(c);
		}
		if (q.size() % 2 != 0) {
			return 0;
		}

		for (int cnt = 0; cnt < str.length(); cnt++) {
			Stack<Character> s = new Stack<>();
			boolean isCorrect = true;
			for (char paren : q) {
				if (paren == '[' || paren == '{' || paren == '(') {
					s.push(paren);
					continue;
				}

				if (s.isEmpty()) {
					isCorrect = false;
					break;
				} else {
					char lParen = s.pop();
					if ((paren == ']' && lParen != '[') ||
						(paren == '}' && lParen != '{') ||
						(paren == ')' && lParen != '(')) {
						isCorrect = false;
						break;
					}
				}
			}

			if (isCorrect) {
				answer++;
			}

			q.offer(q.poll());
		}

		return answer;
	}

}
