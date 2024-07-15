package programmers;

import java.util.*;

public class Programmers43162_2 {
	public int solution(int n, int[][] computers) {
		boolean[] isVisited = new boolean[n];
		int answer = 0;
		for (int computer = 0; computer < n; computer++) {
			if (isVisited[computer]) {
				continue;
			}

			visitAll(computer, computers, isVisited);
			answer++;
		}

		return answer;
	}

	private void visitAll(int computer, int[][] computers, boolean[] isVisited) {
		Deque<Integer> stack = new LinkedList<>();
		stack.push(computer);

		while (!stack.isEmpty()) {
			int start = stack.pop();

			if (isVisited[start]) {
				continue;
			}
			isVisited[start] = true;

			for (int next = 0; next < computers[start].length; next++) {
				if (computers[start][next] == 0) {
					continue;
				}

				stack.push(next);
			}
		}
	}
}
