// Soooo Ez
public class Programmers12949 {
	public int[][] solution(int[][] arr1, int[][] arr2) {
		int row = arr1.length;
		int mid = arr2.length;
		int col = arr2[0].length;

		int[][] answer= new int[row][col];
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				for (int m = 0; m < mid; m++) {
					answer[r][c] += arr1[r][m] * arr2[m][c];
				}
			}
		}

		return answer;
	}
}
