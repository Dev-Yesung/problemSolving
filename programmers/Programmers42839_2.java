import java.util.*;

public class Programmers42839_2 {

	public static void main(String[] args) {
		int solution = new Programmers42839_2()
			.solution("011");
		System.out.println(solution);
	}

	public int solution(String num) {
		Set<Integer> primes = new HashSet<>();
		int[] numbers = num.chars().map(c -> c - '0').toArray();
		boolean[] isUsed = new boolean[numbers.length];

		getPrimes(0, numbers, isUsed, primes);

		return primes.size();
	}

	boolean isPrime(int number) {
		if (number <= 1) {
			return false;
		}

		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}

	void getPrimes(int acc, int[] numbers, boolean[] isUsed, Set<Integer> primes) {
		if (isPrime(acc)) {
			primes.add(acc);
		}

		for (int i = 0; i < numbers.length; i++) {
			if (isUsed[i]) {
				continue;
			}

			int nextAcc = acc * 10 + numbers[i];
			isUsed[i] = true;
			getPrimes(nextAcc, numbers, isUsed, primes);
			isUsed[i] = false;
		}
	}

}
