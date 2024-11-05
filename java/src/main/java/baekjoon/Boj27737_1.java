package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj27737_1 {

	/*
		N * N = 100 * 100 = 10_000
		M = 1_000_000
		K = 100_000_000
	 */
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] tokens = readLine().split(" ");
		int n = Integer.parseInt(tokens[0]);
		int m = Integer.parseInt(tokens[1]);
		int k = Integer.parseInt(tokens[2]);

		int[][] board = getBoard(n);


	}

	private static int[][] getBoard(int n) throws IOException {
		int[][] board = new int[n][n];
		for (int row = 0; row < n; row++) {
			String[] tokens = readLine().split(" ");
			for (int col = 0; col < n; col++) {
				board[row][col] = Integer.parseInt(tokens[col]);
			}
		}

		return board;
	}

	private static String readLine() throws IOException {
		return br.readLine();
	}

}
