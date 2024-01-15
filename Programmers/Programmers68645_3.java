public class Programmers68645_3 {

	private static final int[] dx = {1, 0, -1};
	private static final int[] dy = {0, 1, -1};

	public int[] solution(int n) {
		int[][] triangle = makeTriangle(n);

		return getResult(triangle, n);
	}

	private int[][] makeTriangle(int n) {
		int[][] triangle = new int[n][n];
		int x = 0;
		int y = 0;
		int value = 1;
		int dir = 0;

		while (true) {
			triangle[x][y] = value;
			value++;
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx >= n || ny >= n || nx < 0 || ny < 0 || triangle[nx][ny] != 0) {
				dir = (dir + 1) % 3;
				nx = x + dx[dir];
				ny = y + dy[dir];
				if (nx >= n || ny >= n || nx < 0 || ny < 0 || triangle[nx][ny] != 0) {
					break;
				}
			}
			x = nx;
			y = ny;
		}

		return triangle;
	}

	private int[] getResult(int[][] triangle, int n) {
		int[] result = new int[(n * (n + 1)) / 2];
		int index = 0;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col <= row; col++) {
				result[index] = triangle[row][col];
				index++;
			}
		}

		return result;
	}
}
