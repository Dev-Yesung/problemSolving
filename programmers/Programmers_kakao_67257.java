import java.util.*;

public class Programmers_kakao_67257 {

	public static void main(String[] args) {
		recursion("", 0, 3);

		for (String[] arr : recursivePrecedences) {
			System.out.println(Arrays.toString(arr));
		}

		long answer = new Programmers_kakao_67257()
			.solution("100-200*300-500+20");

		System.out.println(answer);
	}

	// 조합을 하나하나 찾지 않고 이런 식으로 찾을 수도 있다.
	// 만일 우선순위를 재귀로 찾고 싶다면?
	static String[] operators = new String[] {"+", "-", "*"};
	static boolean[] isVisited = new boolean[3];
	static List<String[]> recursivePrecedences = new ArrayList<>();

	static void recursion(String precedence, int cur, int size) {
		if (cur == size) {
			String[] split = precedence.split("");
			recursivePrecedences.add(split);
			return;
		}

		for (int i = 0; i < 3; i++) {
			String operator = operators[i];
			if (isVisited[i]) {
				continue;
			}
			isVisited[i] = true;
			recursion(precedence + operator, cur + 1, size);
			isVisited[i] = false;
		}
	}

	static String[][] precedences = {
		"+-*".split(""),
		"+*-".split(""),
		"-+*".split(""),
		"-*+".split(""),
		"*+-".split(""),
		"*-+".split(""),
	};

	public long solution(String expression) {
		StringTokenizer tokenizer = new StringTokenizer(expression, "+-*", true);
		List<String> tokens = new ArrayList<>();
		while (tokenizer.hasMoreTokens()) {
			tokens.add(tokenizer.nextToken());
		}

		long max = Long.MIN_VALUE;
		for (String[] precedence : precedences) {
			List<String> copiedList = new ArrayList<>(tokens);
			long value = calculate(copiedList, precedence);
			long result = Math.abs(value);
			max = Math.max(max, result);
		}

		return max;
	}

	long calculate(List<String> tokens, String[] precedence) {
		for (String op : precedence) {
			for (int i = 0; i < tokens.size(); i++) {
				String token = tokens.get(i);
				if (token.equals(op)) {
					long lh = Long.parseLong(tokens.get(i - 1));
					long rh = Long.parseLong(tokens.get(i + 1));
					long result = calculateNumber(lh, rh, token);

					for (int j = 0; j < 3; j++) {
						tokens.remove(i - 1);
					}
					tokens.add(i - 1, String.valueOf(result));
					i -= 2;
				}
			}
		}

		return Long.parseLong(tokens.get(0));
	}

	long calculateNumber(long lh, long rh, String op) {
		return switch (op) {
			case "+" -> lh + rh;
			case "-" -> lh - rh;
			case "*" -> lh * rh;
			default -> 0;
		};
	}
}
