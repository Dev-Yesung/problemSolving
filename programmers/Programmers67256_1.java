import java.util.HashMap;
import java.util.Map;

public class Programmers67256_1 {
	public static void main(String[] args) {
		String answer1 = new Programmers67256_1().solution(new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
		String answer2 = new Programmers67256_1().solution(new int[] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left");
		String answer3 = new Programmers67256_1().solution(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right");
		System.out.println(answer1);
		System.out.println(answer2);
		System.out.println(answer3);
	}

	public String solution(int[] numbers, String hand) {
		Map<Integer, Position> map = getKeyPadMap();
		Position lHand = new Position(3, 0);
		Position rHand = new Position(3, 2);

		StringBuilder answer = new StringBuilder();
		for (int number : numbers) {
			if (number == 1 || number == 4 || number == 7) {
				answer.append('L');
				lHand = map.get(number);
				continue;
			}
			if (number == 3 || number == 6 || number == 9) {
				answer.append('R');
				rHand = map.get(number);
				continue;
			}

			Position numberPosition = map.get(number);
			int lLength = calculateDistance(numberPosition, lHand);
			int rLength = calculateDistance(numberPosition, rHand);
			if (lLength == rLength) {
				if (hand.equals("left")) {
					answer.append("L");
					lHand = map.get(number);
				}
				if (hand.equals("right")) {
					answer.append("R");
					rHand = map.get(number);
				}
			} else if (rLength < lLength) {
				answer.append("R");
				rHand = map.get(number);
			} else {
				answer.append("L");
				lHand = map.get(number);
			}
		}

		return answer.toString();
	}

	private int calculateDistance(Position numberPosition, Position handPosition) {
		return Math.abs(numberPosition.x - handPosition.x) + Math.abs(numberPosition.y - handPosition.y);
	}

	private Map<Integer, Position> getKeyPadMap() {
		Map<Integer, Position> map = new HashMap<>();
		map.put(1, new Position(0, 0));
		map.put(2, new Position(0, 1));
		map.put(3, new Position(0, 2));
		map.put(4, new Position(1, 0));
		map.put(5, new Position(1, 1));
		map.put(6, new Position(1, 2));
		map.put(7, new Position(2, 0));
		map.put(8, new Position(2, 1));
		map.put(9, new Position(2, 2));
		map.put(0, new Position(3, 1));

		return map;
	}

	private static class Position {
		int x;
		int y;

		Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
