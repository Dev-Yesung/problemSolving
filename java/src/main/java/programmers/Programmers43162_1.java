package programmers;

import java.util.*;

public class Programmers43162_1 {
	public int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] isVisited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		for (int computer = 0; computer < n; computer++) {
			if (isVisited[computer]) {
				continue;
			}

			isVisited[computer] = true;
			queue.offer(computer);
			while (!queue.isEmpty()) {
				int start = queue.poll();

				for (int next = 0; next < n; next++) {
					if (next == start || computers[start][next] == 0 || isVisited[next]) {
						continue;
					}

					isVisited[next] = true;
					queue.offer(next);
				}
			}
			answer++;
		}

		return answer;
	}
}
