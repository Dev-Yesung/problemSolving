// https://school.programmers.co.kr/learn/courses/30/lessons/43105

public class Programmers43105_1 {

	static int[] dx = new int[] {1, 1};
	static int[] dy = new int[] {0, 1};

	public int solution(int[][] triangle) {
		int size = triangle.length;
		int[][] mem = new int[size][size];
		mem[0][0] = triangle[0][0];
		for (int level = 0; level < size - 1; level++) {
			for (int cur = 0; cur < triangle[level].length; cur++) {
				for (int dir = 0; dir <= 1; dir++) {
					int nx = level + dx[dir];
					int ny = cur + dy[dir];
					int now = mem[level][cur];
					int nxt = triangle[nx][ny];
					mem[nx][ny] = Math.max(mem[nx][ny], now + nxt);
				}
			}
		}

		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < mem[size - 1].length; i++) {
			answer = Math.max(mem[size - 1][i], answer);
		}

		return answer;
	}

}
