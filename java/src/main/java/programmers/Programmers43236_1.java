import java.util.*;
// https://school.programmers.co.kr/learn/courses/30/lessons/43236
// 징검다리

public class Programmers43236_1 {

	public int solution(int distance, int[] rocks, int n) {
		rocks = Arrays.copyOf(rocks, rocks.length + 1);
		rocks[rocks.length - 1] = distance;
		Arrays.sort(rocks);

		int start = 1;
		int end = distance + 1;
		while (end - start > 1) {
			int d = (start + end) / 2;
			if (isValid(d, rocks, n)) {
				start = d;
			} else {
				end = d;
			}
		}

		return start;
	}

	boolean isValid(int d, int[] rocks, int n) {
		int removed = 0;
		int last = 0;
		for (int rock : rocks) {
			if (rock - last < d) {
				removed++;
				continue;
			}
			last = rock;
		}

		return removed <= n;
	}
}
