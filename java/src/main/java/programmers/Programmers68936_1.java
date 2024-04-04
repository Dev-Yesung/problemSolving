import java.util.Arrays;

public class Programmers68936_1 {

	public static void main(String[] args) {
		int[][] arr = new int[][] {
			{1, 1, 0, 0},
			{1, 0, 0, 0},
			{1, 0, 0, 1},
			{1, 1, 1, 1}
		};

		int[] answer = new Programmers68936_1()
			.solution(arr);

		System.out.println(Arrays.toString(answer));
	}

	static int[] answer = new int[2];

	public int[] solution(int[][] arr) {
		int len = arr.length;
		recursion(arr, 0, 0, len);

		// 정답 리턴
		return answer;
	}

	void recursion(int[][] arr, int rs, int cs, int len) {
		// 1. 모두 같은 수 인지 체크
		boolean isAllSame = isAllSame(arr, rs, cs, len);
		if (isAllSame) {
			// 2. 모두 같은 수라면 원소에 해당하는 카운터 수 업데이트 후 리턴
			answer[arr[rs][cs]]++;
			return;
		}

		// 3. 모두 같은 수가 아니라면 4분할 한 후 하나로 들어간다.
		for (int row = rs; row < rs + len; row += len / 2) {
			for (int col = cs; col < cs + len; col += len / 2) {
				// System.out.println("row : " + row + ", col : " + col + ", len : " + len);
				recursion(arr, row, col, len / 2);
			}
		}
	}

	boolean isAllSame(int[][] arr, int rs, int cs, int len) {
		boolean isAllSame = true;
		int element = arr[rs][cs];
		for (int row = rs; row < rs + len; row++) {
			for (int col = cs; col < cs + len; col++) {
				if (arr[row][col] != element) {
					isAllSame = false;
					break;
				}
			}
			if (!isAllSame) {
				break;
			}
		}
		return isAllSame;
	}
}
