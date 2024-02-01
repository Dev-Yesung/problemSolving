import java.io.*;
import java.util.*;

// https://softeer.ai/practice/6257
// 통근버스 출발 순서 검증하기
public class Softeer6257 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = parseInt(br.readLine());

		int[] bus = getBus(n);
		int[][] mat = getMatrix(bus, n);
		long count = countNoValidOrder(mat, bus, n);

		System.out.println(count);
	}

	private static int[] getBus(int n) throws IOException {
		int[] bus = new int[n + 1];
		String[] values = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			bus[i] = parseInt(values[i]);
		}

		return bus;
	}

	private static int[][] getMatrix(int[] bus, int n) {
		int[][] mat = new int[n + 1][n + 1];
		for (int x = 1; x <= n; x++) {
			for (int j = n - 2; j >= 0; j--) {
				if (bus[j + 1] < x) {
					mat[x][j] = mat[x][j + 1] + 1;
				} else {
					mat[x][j] = mat[x][j + 1];
				}
			}
		}

		return mat;
	}

	private static long countNoValidOrder(int[][] mat, int[] bus, int n) {
		long count = 0;
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				// i보다 값이 작으면서 j보다 값이 작은 배열의 오른쪽 수들의 개수
				// 여기서 조건 반드시 체크해야 함
				if (bus[i] < bus[j]) {
					count += mat[bus[i]][j];
				}
			}
		}

		return count;
	}

	private static int parseInt(String str) {
		return Integer.parseInt(str);
	}
}
