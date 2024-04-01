import java.util.Arrays;
import java.util.Stack;

public class Programmers42584_1 {

	public static void main(String[] args) {
		int[] answer = new Programmers42584_1()
			.solution(new int[] {1, 2, 3, 2, 3});

		System.out.println(Arrays.toString(answer));
	}

	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < prices.length; i++) {
			while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
				int idx = stack.pop();
				answer[idx] = i - idx;
			}

			stack.push(i);
		}

		while (!stack.isEmpty()) {
			int idx = stack.pop();
			answer[idx] = (prices.length - 1) - idx;
		}

		return answer;
	}

}
