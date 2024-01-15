public class Programmers68645_1 {
	public int[] solution(int n) {
		int[][] matrix = initialize(n);

		return getAnswer(matrix, n);
	}

	private int[][] initialize(int n) {
		int[][] matrix = new int[n][n];
		int row = 0;
		int col = 0;
		int num = 1;

		for (int i = 0; i < n; i++) {
			// 아래로 이동
			while (row < n - i) {
				if (matrix[row][col] == 0) {
					matrix[row][col] = num;
					num++;
				}
				row++;
			}
			// 범위를 벗어난 후 한 칸 위로 이동
			row--;
			col++;

			// 오른쪽으로 이동
			while (col < n - i) {
				if (matrix[row][col] == 0) {
					matrix[row][col] = num;
					num++;
				}
				col++;
			}
			// 범위를 벗어난 후 한 칸 왼쪽으로 이동
			col--;
			row--;
			col--;

			// 대각선으로 이동
			while (row > i && col > i) {
				if (matrix[row][col] == 0) {
					matrix[row][col] = num;
					num++;
				}
				row--;
				col--;
			}
			// 범위를 벗어난 후 한 칸 아래, 오른쪽으로 이동
			row++;
			col++;
			row++;
		}

		return matrix;
	}

	private int[] getAnswer(int[][] matrix, int n) {
		int length = n * (n + 1) / 2;
		int[] answer = new int[length];

		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				answer[idx++] = matrix[i][j];
			}
		}

		return answer;
	}
}
