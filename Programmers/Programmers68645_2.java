public class Programmers68645_2 {
	public int[] solution(int n) {
		int[][] triangle = makeTriangle(n);

		return getResult(triangle, n);
	}

	private int[][] makeTriangle(int n) {
		int[][] triangle = new int[n][n];
		int row = 0;
		int col = 0;
		int value = 1;

		while (true) {
			// 아래로 이동
			while (true) {
				triangle[row][col] = value++;
				if (row + 1 == n || triangle[row + 1][col] != 0) {
					break;
				}
				row++;
			}
			if (col + 1 == n || triangle[row][col + 1] != 0) {
				break;
			}
			col++;

			// 오른쪽으로 이동
			while (true) {
				triangle[row][col] = value++;
				if (col + 1 == n || triangle[row][col + 1] != 0) {
					break;
				}
				col++;
			}
			if (triangle[row - 1][col - 1] != 0) {
				break;
			}
			col--;
			row--;

			while (true) {
				triangle[row][col] = value++;
				if (triangle[row - 1][col - 1] != 0) {
					break;
				}
				col--;
				row--;
			}
			if (row + 1 == n || triangle[row + 1][col] != 0) {
				break;
			}
			row++;
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
