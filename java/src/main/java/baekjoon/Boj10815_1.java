package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Boj10815_1 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] cards = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.sorted()
			.toArray();
		int m = Integer.parseInt(br.readLine());
		int[] numbers = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int[] answer = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			int start = 0;
			int end = cards.length;
			while (end > start) {
				// -10 2 3 6 10
				// start  = 0; end = 5
				int mid = (start + end) / 2;
				if (numbers[i] > cards[mid]) {
					start = mid + 1;
				} else if (numbers[i] < cards[mid]) {
					end = mid;
				} else {
					answer[i] = 1;
					break;
				}
			}
		}

		System.out.println(Arrays.stream(answer)
			.mapToObj(String::valueOf)
			.collect(Collectors.joining(" ")));
	}
}
