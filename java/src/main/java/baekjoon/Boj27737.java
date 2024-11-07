package baekjoon;

import java.io.*;
import java.util.*;

public class Boj27737 {

	private static final int[] dx = {-1, 0, 1, 0};
	private static final int[] dy = {0, 1, 0, -1};
	private static final int INVALID_POS = 1;
	private static final int VISITED_POS = 2;
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int[] tokens = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		int n = tokens[0];
		int m = tokens[1];
		int k = tokens[2];

		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		}

		int usedSeedSize = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int val = map[i][j];
				if (val == INVALID_POS || val == VISITED_POS) {
					continue;
				}

				int counter = 0;
				Queue<Pair> q = new LinkedList<>();
				q.offer(new Pair(i, j));
				map[i][j] = VISITED_POS;
				counter++;
				while (!q.isEmpty()) {
					Pair cur = q.poll();

					for (int dir = 0; dir < 4; dir++) {
						int nx = cur.row + dx[dir];
						int ny = cur.col + dy[dir];

						if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
							continue;
						}
						if (map[nx][ny] == INVALID_POS || map[nx][ny] == VISITED_POS) {
							continue;
						}

						map[nx][ny] = VISITED_POS;
						counter++;
						q.offer(new Pair(nx, ny));
					}
				}
				if (counter % k != 0) {
					usedSeedSize += (counter / k) + 1;
				} else {
					usedSeedSize += counter / k;
				}
			}
		}

		if (usedSeedSize == 0) {
			System.out.println("IMPOSSIBLE");
		} else {
			if (usedSeedSize <= m) {
				System.out.println("POSSIBLE");
				System.out.println(m - usedSeedSize);
			} else {
				System.out.println("IMPOSSIBLE");
			}
		}
	}

	private static class Pair {
		int row;
		int col;

		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
