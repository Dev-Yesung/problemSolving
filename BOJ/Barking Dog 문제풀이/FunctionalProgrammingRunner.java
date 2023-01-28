package ps;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunctionalProgrammingRunner {
	public static void main(String[] args) {
		List<Integer> newList = List.of(23, 12, 33, 54).stream().filter(number -> number % 2 == 0)
			.collect(Collectors.toList());
		System.out.println(newList);

		List<Integer> newList2 =
			IntStream.range(1, 21).limit(10).map(num -> (int) Math.pow(num, 2.0)).boxed()
				.collect(Collectors.toList());
		System.out.println(newList2);
	}
}
