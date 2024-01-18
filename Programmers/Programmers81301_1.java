/*
	https://school.programmers.co.kr/learn/courses/30/lessons/81302
	레벨 : 2
	풀이시간 : 40분
	정확성 테스트 : 100
 */

public class Programmers81301_1 {
	public int[] solution(String[][] places) {
		int[] answer = new int[5];
		for (int i = 0; i < 5; i++) {
			String[] place = places[i];
			char[][] room = getRoom(place);
			boolean isDistanced = isDistanced(room);
			if (isDistanced) {
				answer[i] = 1;
			} else {
				answer[i] = 0;
			}
		}

		return answer;
	}

	private char[][] getRoom(String[] place) {
		char[][] room = new char[5][5];
		for (int r = 0; r < 5; r++) {
			room[r] = place[r].toCharArray();
		}
		return room;
	}

	private boolean isDistanced(char[][] room) {
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				if (room[r][c] != 'P') {
					continue;
				}
				if (!isDistancedLength(room, r, c, 1) || !isDistancedLength(room, r, c, 2)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isDistancedLength(char[][] room, int r, int c, int d) {
		// 왼쪽 체크
		if (c - d >= 0 && room[r][c - d] == 'P') {
			if (d == 1) {
				return false;
			}
			if (d == 2 && room[r][c - 1] != 'X') {
				return false;
			}
		}
		// 위쪽 체크
		if (r - d >= 0 && room[r - d][c] == 'P') {
			if (d == 1) {
				return false;
			}
			if (d == 2 && room[r - 1][c] != 'X') {
				return false;
			}
		}
		// 오른쪽 체크
		if (c + d < 5 && room[r][c + d] == 'P') {
			if (d == 1) {
				return false;
			}
			if (d == 2 && room[r][c + 1] != 'X') {
				return false;
			}
		}
		// 아래쪽 체크
		if (r + d < 5 && room[r + d][c] == 'P') {
			if (d == 1) {
				return false;
			}
			if (d == 2 && room[r + 1][c] != 'X') {
				return false;
			}
		}

		// d가 1인 경우만 대각선 체크 && 파티션 체크
		if (d == 1) {
			// 왼쪽 위 대각선
			if (c - d >= 0 && r - d >= 0 && room[r - d][c - d] == 'P') {
				if (room[r][c - d] != 'X' || room[r - d][c] != 'X') {
					return false;
				}
			}
			// 왼쪽 아래 대각선
			if (c - d >= 0 && r + d < 5 && room[r + d][c - d] == 'P') {
				if (room[r][c - d] != 'X' || room[r + d][c] != 'X') {
					return false;
				}
			}
			// 오른쪽 위 대각선
			if (c + d < 5 && r - d >= 0 && room[r - d][c + d] == 'P') {
				if (room[r][c + d] != 'X' || room[r - d][c] != 'X') {
					return false;
				}
			}
			// 오른쪽 아래 대각선
			if (c + d < 5 && r + d < 5 && room[r + d][c + d] == 'P') {
				// 오른쪽 파티션이 아닌 경우
				if (room[r][c + d] != 'X' || room[r + d][c] != 'X') {
					return false;
				}
			}
		}
		return true;
	}
}
