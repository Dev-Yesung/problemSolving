// https://school.programmers.co.kr/learn/courses/30/lessons/43238
// 입국심사

public class Programmers43238_1 {
	public static void main(String[] args) {
		long answer = new Programmers43238_1()
			.solution(6, new int[] {7, 10});

		System.out.println(answer);
	}

	public long solution(int n, int[] times) {
		long start = 1L;
		long end = 1_000_000_000L * 100_000;

		while (end > start) {
			long mid = (start + end) / 2;
			if (isValid(mid, n, times)) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return start;
	}

	boolean isValid(long t, int n, int[] times) {
		long count = 0L;
		for (int time : times) {
			count += t / time;
		}

		return count >= n;
	}

}
