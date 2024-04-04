import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12945
// 참고 : https://school.programmers.co.kr/questions/25054
// 참고 : https://alive-wong.tistory.com/59
// 참고 : https://velog.io/@sw801733/%EB%82%98%EB%A8%B8%EC%A7%80-%EC%97%B0%EC%82%B0-%EB%B6%84%EB%B0%B0%EB%B2%95%EC%B9%99-%EB%AA%A8%EB%93%88%EB%9F%AC-%EC%97%B0%EC%82%B0

// 피보나치 결과에 의해 long 범위를 넘어가는 경우가 있기 때문에 발생하는 문제!
// (num1 + num2) % N == ((num1 % N) + (num2 % N)) % N 이라는 것을 기억해서 숫자를 작게 만들어주자.

public class Programmers12945_1 {

	static final int[] table = new int[100_001];

	public int solution(int n) {
		Arrays.fill(table, -1);

		for (int i = 0; i <= n; i++) {
			fibo(i);
		}

		return fibo(n);
	}

	int fibo(int n) {
		if (table[n] != -1) {
			return table[n];
		}
		if (n <= 1) {
			return n;
		}

		return table[n] = (fibo(n - 1) + fibo(n - 2)) % 1234567;
	}
}
