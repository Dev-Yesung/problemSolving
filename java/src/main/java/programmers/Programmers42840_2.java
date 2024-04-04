import java.util.*;
import java.util.stream.*;

public class Programmers42840_2 {

	public static void main(String[] args) {
		int[] arr = new Programmers42840_2()
			.solution(new int[] {1, 3, 2, 4, 2});

		System.out.println(Arrays.toString(arr));
	}

	private static final int[][] RULES = {
		{1, 2, 3, 4, 5},
		{2, 1, 2, 3, 2, 4, 2, 5},
		{3, 3, 1, 1, 2, 2, 4, 4, 5, 5},
	};

	public int[] solution(int[] answers) {
		int[] corrects = new int[3];
		int max = 0;
		for (int problem = 0; problem < answers.length; problem++) {
			int answer = answers[problem];
			for (int person = 0; person < 3; person++) {
				int picked = getPicked(person, problem);
				if (picked == answer) {
					corrects[person]++;
					if (corrects[person] > max) {
						max = corrects[person];
					}
				}
			}
		}
		int maxCorrects = max;

		// IntStream 으로 범위 만들어서 for 문을 대체할 수 있다.
		return IntStream.range(0, 3)
			.filter(i -> corrects[i] == maxCorrects)
			.map(i -> i + 1)
			.toArray();
	}

	private int getPicked(int person, int problem) {
		int[] rule = RULES[person];
		int index = problem % rule.length;

		return rule[index];
	}
}
