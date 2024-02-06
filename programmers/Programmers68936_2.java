import java.util.Arrays;

public class Programmers68936_2 {

	public static void main(String[] args) {
		int[][] arr = new int[][] {
			{1, 1, 0, 0},
			{1, 0, 0, 0},
			{1, 0, 0, 1},
			{1, 1, 1, 1}
		};

		int[] answer = new Programmers68936_2()
			.solution(arr);

		System.out.println(Arrays.toString(answer));
	}

	public int[] solution(int[][] arr) {
		Count count = count(0, 0, arr.length, arr);

		return new int[] {count.zero, count.one};
	}

	private Count count(int offsetX, int offsetY, int size, int[][] arr) {
		int h = size / 2;
		for (int x = offsetX; x < offsetX + size; x++) {
			for (int y = offsetY; y < offsetY + size; y++) {
				if (arr[x][y] != arr[offsetX][offsetY]) {
					return count(offsetX, offsetY, h, arr)
						.add(count(offsetX + h, offsetY, h, arr))
						.add(count(offsetX, offsetY + h, h, arr))
						.add(count(offsetX + h, offsetY + h, h, arr));
				}
			}
		}

		if (arr[offsetX][offsetY] == 1) {
			return new Count(0, 1);
		}
		return new Count(1, 0);
	}

	private static class Count {
		public final int zero;
		public final int one;

		public Count(int zero, int one) {
			this.zero = zero;
			this.one = one;
		}

		public Count add(Count other) {
			return new Count(zero + other.zero, one + other.one);
		}
	}
}
