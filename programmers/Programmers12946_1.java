import java.util.*;
import java.util.stream.Collectors;

public class Programmers12946_1 {

	public static void main(String[] args) {
		int[][] answer = new Programmers12946_1()
			.solution(2);

		String formattedAnswer = Arrays.stream(answer)
			.map(Arrays::toString)
			.collect(Collectors.joining(", "));
		System.out.println("[" + formattedAnswer + "]");
	}

	static List<int[]> list = new ArrayList<>();

	public int[][] solution(int n) {
		move(n, 1, 3);

		return list.toArray(new int[0][]);
	}

	void move(int n, int from, int to) {
		if (n == 1) {
			int[] route = new int[] {from, to};
			list.add(route);

			return;
		}

		int empty = 6 - from - to;
		move(n - 1, from, empty);
		move(1, from, to);
		move(n - 1, empty, to);
	}
}
