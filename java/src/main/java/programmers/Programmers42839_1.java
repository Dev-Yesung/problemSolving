import java.util.*;

public class Programmers42839_1 {

	public static void main(String[] args) {
		int answer = new Programmers42839_1()
			.solution("011");
		System.out.println(answer);
	}

	Set<Integer> answer = new HashSet<>();

	public int solution(String numbers) {
		String[] split = numbers.split("");
		int length = split.length;
		boolean[] isVisited = new boolean[length];
		combination(split, isVisited, "", 0, length);

		System.out.println(Arrays.toString(answer.toArray()));
		return answer.size();
	}

	boolean isPrime(int number) {
		if (number == 0 || number == 1) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}

	void combination(String[] numbers, boolean[] isVisited, String comb, int cur, int len) {
		if (!comb.isEmpty()) {
			// 앞뒤로 0이 있다면 제거
			int number = Integer.parseInt(comb);
			// 제거한 숫자가 소수인지 판별
			if (isPrime(number)) {
				answer.add(number);
			}
		}

		if (cur == len) {
			return;
		}

		// 재귀로 보낼때는 0이 제거 안된 문자열을 보내자.
		for (int i = 0; i < len; i++) {
			if (isVisited[i]) {
				continue;
			}
			isVisited[i] = true;
			combination(numbers, isVisited, comb + numbers[i], cur + 1, len);
			isVisited[i] = false;
		}
	}
}
