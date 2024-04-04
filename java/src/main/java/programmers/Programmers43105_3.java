import java.util.Arrays;

// 왼쪽 혹은 오른쪽 대각선으로 가는 것에 따라 계속해서 삼각형 모양과 계산이 반복됨
// -> 재귀로 풀 수 있음
// 또한 삼각형을 이루는 숫자들의 최대값이 필요한데 계산하는 위치가 겹침
// -> 메모이제이션으로 최적화 가능

public class Programmers43105_3 {
	static int[][] mem = new int[501][501];

	public int solution(int[][] triangle) {
		for (int[] row : mem) {
			Arrays.fill(row, -1);
		}

		return max(0, 0, triangle);
	}

	int max(int x, int y, int[][] triangle) {
		if (y == triangle.length) {
			return 0;
		}

		if (mem[x][y] != -1) {
			return mem[x][y];
		}

		return mem[x][y] = triangle[y][x] + Math.max(
			max(x, y + 1, triangle),
			max(x + 1, y + 1, triangle));
	}
}
