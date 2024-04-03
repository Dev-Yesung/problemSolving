import java.util.Arrays;
import java.util.stream.Collectors;

public class Programmers67256_2 {

	public static void main(String[] args) {
		String answer1 = new Programmers67256_2()
			.solution(new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
		String answer2 = new Programmers67256_2()
			.solution(new int[] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left");
		String answer3 = new Programmers67256_2()
			.solution(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right");

		System.out.println(answer1);
		System.out.println(answer2);
		System.out.println(answer3);
	}

	public String solution(int[] numbers, String hand) {
		Hand right = new Hand("R", hand.equals("right"), 2);
		Hand left = new Hand("L", hand.equals("left"), 0);

		return Arrays.stream(numbers)
			.mapToObj(n -> press(n, right, left).hand)
			.collect(Collectors.joining());
	}

	private Hand press(int number, Hand right, Hand left) {
		int x = getX(number);
		int y = getY(number);

		float rDistance = right.distance(x, y);
		float lDistance = left.distance(x, y);

		Hand hand = lDistance < rDistance ? left : right;
		hand.move(x, y);

		return hand;
	}

	private int getX(int number) {
		if (number == 0) {
			return 1;
		}

		return (number - 1) % 3;
	}

	private int getY(int number) {
		if (number == 0) {
			return 3;
		}

		return (number - 1) / 3;
	}

	private static class Hand {
		private final int baseX;
		public final String hand;
		public final float preference;
		private int x;
		private int y;

		public Hand(String hand, boolean isPreferred, int x) {
			this.hand = hand;
			this.baseX = x;
			this.preference = isPreferred ? 0.5f : 0;
			this.x = x;
			this.y = 3;
		}

		public float distance(int x, int y) {
			if (x == baseX) {
				return 0;
			}
			int distance = Math.abs(x - this.x) + Math.abs(y - this.y);

			return distance - preference;
		}

		public void move(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
