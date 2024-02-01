// 개선된 풀이
public class Programmers81301_2 {
	private static final int[] dx = {0, -1, 1, 0};
	private static final int[] dy = {-1, 0, 0, 1};

	public int[] solution(String[][] places) {
		int[] answer = new int[places.length];
		for (int i = 0; i < places.length; i++) {
			String[] place = places[i];
			char[][] room = new char[5][5];
			for (int j = 0; j < room.length; j++) {
				room[j] = place[j].toCharArray();
			}
			if (isDistanced(room)) {
				answer[i] = 1;
			} else {
				answer[i] = 0;
			}
		}

		return answer;
	}

	private boolean isDistanced(char[][] room) {
		for (int x = 0; x < room.length; x++) {
			for (int y = 0; y < room[x].length; y++) {
				if (room[x][y] != 'P') {
					continue;
				}
				if (!isDistanced(room, x, y)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isDistanced(char[][] room, int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || nx >= room.length || ny < 0 || ny >= room[nx].length) {
				continue;
			}
			if (room[nx][ny] == 'P') {
				return false;
			}
			if (room[nx][ny] == 'O') {
				if (isNextToPlayer(room, nx, ny, 3 - d)) {
					return false;
				}
			}
		}

		return true;
	}

	private boolean isNextToPlayer(char[][] room, int x, int y, int exclude) {
		for (int d = 0; d < 4; d++) {
			if (d == exclude) {
				continue;
			}

			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || nx >= room.length || ny < 0 || ny >= room[nx].length) {
				continue;
			}

			if (room[nx][ny] == 'P') {
				return true;
			}
		}
		return false;
	}
}
