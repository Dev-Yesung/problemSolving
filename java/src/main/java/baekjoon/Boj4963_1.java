package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Boj4963_1 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final int[] dx = {1, 0, -1, 0, -1, -1, 1, 1};
	private static final int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};

	public static void main(String[] args) throws IOException {
		StringBuilder answer = new StringBuilder();
		while (true) {
			String[] tokens = br.readLine().split(" ");
			int width = Integer.parseInt(tokens[0]);
			int height = Integer.parseInt(tokens[1]);
			if (width == 0 && height == 0) {
				break;
			}

			int[][] map = new int[height][width];
			for (int i = 0; i < height; i++) {
				String[] row = br.readLine().split(" ");
				for (int j = 0; j < width; j++) {
					map[i][j] = Integer.parseInt(row[j]);
				}
			}

			answer.append(countIsland(map, width, height))
					.append('\n');
		}

		System.out.println(answer);
	}

	private static int countIsland(int[][] map, int width, int height) {
		int count = 0;
		boolean[][] isVisited = new boolean[height][width];
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (map[i][j] == 0 || isVisited[i][j]) {
					continue;
				}

				queue.offer(new int[] {i, j});
				isVisited[i][j] = true;
				while (!queue.isEmpty()) {
					int[] currentPosition = queue.poll();
					int currentX = currentPosition[0];
					int currentY = currentPosition[1];

					for (int direction = 0; direction < 8; direction++) {
						int nx = currentX + dx[direction];
						int ny = currentY + dy[direction];

						if (nx < 0 || nx >= height || ny < 0 || ny >= width) {
							continue;
						}
						if (map[nx][ny] == 0) {
							continue;
						}
						if (isVisited[nx][ny]) {
							continue;
						}

						queue.offer(new int[] {nx, ny});
						isVisited[nx][ny] = true;
					}
				}

				count++;
			}
		}

		return count;
	}
}
