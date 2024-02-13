import java.util.Arrays;
import java.util.stream.Collectors;

public class Programmers42746_2 {

	public static void main(String[] args) {
		Programmers42746_2 prgrms = new Programmers42746_2();
		String answer1 = prgrms.solution(new int[] {3, 30, 34, 5, 9});
		String answer2 = prgrms.solution(new int[] {0, 0, 0, 0});

		System.out.println(answer1);
		System.out.println(answer2);
	}

	public String solution(int[] numbers) {
		return Arrays.stream(numbers)
			.mapToObj(String::valueOf)
			.sorted((n1, n2) -> {
				int origin = Integer.parseInt(n1 + n2);
				int reverse = Integer.parseInt(n2 + n1);

				return reverse - origin;
			})
			.collect(Collectors.joining(""))
			.replaceAll("^0+", "0");
	}

}
