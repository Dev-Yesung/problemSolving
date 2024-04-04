import java.util.*;

public class Programmers42898_1 {

	static int[][] mem = new int[101][101];

	public int solution(int m, int n, int[][] puddles) {
		for (int i = 1; i <= 100; i++) {
			Arrays.fill(mem[i], -1);
		}

		int[][] map = new int[n + 1][m + 1];
		for (int[] pos : puddles) {
			int x = pos[0];
			int y = pos[1];
			map[y][x] = -1;
		}

		return recursion(map, 1, 1, m, n);
	}

	int recursion(int[][] map, int x, int y, int m, int n) {
		if (x > m || y > n) {
			return 0;
		}
		if (map[y][x] == -1) {
			return 0;
		}

		if (mem[x][y] != -1) {
			return mem[x][y];
		}
		if (x == m && y == n) {
			return 1;
		}

		int v1 = recursion(map, x + 1, y, m, n);
		int v2 = recursion(map, x, y + 1, m, n);
		mem[x][y] = (v1 + v2) % 1_000_000_007;

		return mem[x][y];
	}

}
