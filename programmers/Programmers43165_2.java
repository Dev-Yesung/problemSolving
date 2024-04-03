import java.util.Stack;

public class Programmers43165_2 {

	public static void main(String[] args) {
		int answer1 = new Programmers43165_2()
			.solution(new int[] {1, 1, 1, 1, 1}, 3);
		int answer2 = new Programmers43165_2()
			.solution(new int[] {4, 1, 2, 1}, 4);

		System.out.println(answer1);
		System.out.println(answer2);
	}

	public int solution(int[] numbers, int target) {
		Stack<State> stack = new Stack<>();
		stack.push(new State(0, 0));
		int count = 0;
		while (!stack.isEmpty()) {
			State state = stack.pop();

			if (state.index == numbers.length) {
				if (state.acc == target) {
					count++;
				}
				continue;
			}

			stack.push(new State(state.index + 1,
				state.acc + numbers[state.index]));
			stack.push(new State(state.index + 1,
				state.acc - numbers[state.index]));
		}

		return count;
	}

	private static class State {
		public int index;
		public int acc;

		State(int index, int acc) {
			this.index = index;
			this.acc = acc;
		}
	}
}
