import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/87377
// 처음 풀이
public class Prgrms87377_1 {
	public String[] solution(int[][] line) {
		int rowSize = line.length;
		// System.out.println(rowSize);

		List<Pair> list = new ArrayList<>();
		for (int r = 0; r < rowSize; r++) {
			for (int nxt = r + 1; nxt < rowSize; nxt++) {
				int A = line[r][0];
				int B = line[r][1];
				int E = line[r][2];
				// System.out.println(A + ", " + B + ", " + E);

				int C = line[nxt][0];
				int D = line[nxt][1];
				int F = line[nxt][2];
				// System.out.println(C + ", " + D + ", " + F);

				long det = A * D - B * C;
				if (det == 0) {
					continue;
				}

				double x = (B * F - E * D) / (double)det;
				double y = (E * C - A * F) / (double)det;

				if (!(isInteger(x) && isInteger(y))) {
					continue;
				}

				// System.out.println((int)x + ", " + (int)y);
				list.add(new Pair((int)x, (int)y));
			}
		}

		int maxX = Integer.MIN_VALUE;
		int minX = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE;
		for (Pair p : list) {
			maxX = Math.max(maxX, p.x);
			maxY = Math.max(maxY, p.y);
			minX = Math.min(minX, p.x);
			minY = Math.min(minY, p.y);
		}

		// 좌표를 변환하는 부분에서 어려움을 겪었음
		int width = (int)(maxX - minX + 1);
		int height = (int)(maxY - minY + 1);
		// System.out.println(width + ", " + height);
		char[][] arr = new char[height][width];
		for (char[] row : arr) {
			Arrays.fill(row, '.');
		}

		for (Pair p : list) {
			arr[maxY - p.y][p.x - minX] = '*';
		}

		String[] answer = new String[arr.length];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = new String(arr[i]);
		}
		return answer;
	}

	boolean isInteger(double num) {
		return num % 1 == 0.0;
	}

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
