package ps;

import java.io.*;

public class Boj1149 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final int R = 0;
	private static final int G = 1;
	private static final int B = 2;

	public static void main(String[] args) throws IOException {
		int[][] mat = new int[3][1000];
		int n = parseInt(br.readLine());
		inputPrice(mat, n);
		int answer = getAnswer(mat, n);

		System.out.println(answer);
	}

	private static int getAnswer(int[][] mat, int n) {
		for (int cur = 1; cur < n; cur++) {
			// 빨강조합의 최소값 구하기
			int rVal1 = mat[R][cur] + mat[G][cur - 1];
			int rVal2 = mat[R][cur] + mat[B][cur - 1];
			mat[R][cur] = Math.min(rVal1, rVal2);
			// 초록 조합의 최소값 구하기
			int gVal1 = mat[G][cur] + mat[R][cur - 1];
			int gVal2 = mat[G][cur] + mat[B][cur - 1];
			mat[G][cur] = Math.min(gVal1, gVal2);
			// 파랑 조합의 최소값 구하기
			int bVal1 = mat[B][cur] + mat[R][cur - 1];
			int bVal2 = mat[B][cur] + mat[G][cur - 1];
			mat[B][cur] = Math.min(bVal1, bVal2);
		}

		int rPrice = mat[R][n - 1];
		int gPrice = mat[G][n - 1];
		int bPrice = mat[B][n - 1];

		return Math.min(Math.min(rPrice, gPrice), bPrice);
	}

	private static void inputPrice(int[][] mat, int n) throws IOException {
		for (int i = 0; i < n; i++) {
			String[] values = splitString(br.readLine());
			for (int j = 0; j < 3; j++) {
				int price = parseInt(values[j]);
				mat[j][i] = price;
			}
		}
	}

	private static int parseInt(String str) {
		return Integer.parseInt(str);
	}

	private static String[] splitString(String str) {
		return str.split(" ");
	}
}
