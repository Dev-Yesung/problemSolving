package programmers;

import java.util.*;

public class Programmers1844_1 {
	private static final int WALL = 0;
	private static final int[] dx = {1, 0, -1, 0};
	private static final int[] dy = {0, 1, 0, -1};

	public int solution(int[][] maps) {
		int row = maps.length;
		int col = maps[0].length;
		int[][] step = new int[row][col];
		Queue<Position> queue = new LinkedList<>();

		queue.offer(new Position(0, 0));
		step[0][0] = 1;
		while (!queue.isEmpty()) {
			Position cur = queue.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];

				if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
					continue;
				}
				if (maps[nx][ny] == WALL) {
					continue;
				}
				if (step[nx][ny] > 0) {
					continue;
				}

				queue.offer(new Position(nx, ny));
				step[nx][ny] = step[cur.x][cur.y] + 1;
			}
		}

		int answer = step[row - 1][col - 1];
		if (answer == 0) {
			return -1;
		}

		return answer;
	}

	private static class Position {
		public final int x;
		public final int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
