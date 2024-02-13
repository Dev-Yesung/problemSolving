import java.util.*;
import java.util.stream.*;

public class Programmers42746_1 {

	public static void main(String[] args) {
		Programmers42746_1 prgrms = new Programmers42746_1();
		String answer1 = prgrms.solution(new int[] {3, 30, 34, 5, 9});
		String answer2 = prgrms.solution(new int[] {0, 0, 0, 0});

		System.out.println(answer1);
		System.out.println(answer2);
	}

	public String solution(int[] numbers) {
		String answer = Arrays.stream(numbers)
			.boxed()
			.map(String::valueOf)
			.sorted((n1, n2) -> (n2 + n1).compareTo(n1 + n2))
			.collect(Collectors.joining(""));

		return answer.startsWith("0") ? "0" : answer;
	}

}
