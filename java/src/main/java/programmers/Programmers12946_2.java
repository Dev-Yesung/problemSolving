import java.util.*;
import java.util.stream.Collectors;

public class Programmers12946_2 {

	public static void main(String[] args) {
		int[][] answer = new Programmers12946_2()
			.solution(15);

		String formattedAnswer = Arrays.stream(answer)
			.map(Arrays::toString)
			.collect(Collectors.joining(", "));
		System.out.println("[" + formattedAnswer + "]");
	}

	static List<int[]> process = new ArrayList<>();

	public int[][] solution(int n) {
		hanoi(n, 1, 3);

		return process.toArray(new int[0][]);
	}

	private void hanoi(int n, int from, int to) {
		if (n == 1) {
			process.add(new int[] {from, to});

			return;
		}

		int empty = 6 - from - to;
		hanoi(n - 1, from, empty);
		hanoi(1, from, to);
		hanoi(n - 1, empty, to);
	}
}
