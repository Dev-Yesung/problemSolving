package ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj3273 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static boolean[] arr = new boolean[2_000_001];
	private static int n, x, total;
	private static String numbers;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		numbers = br.readLine();
		x = Integer.parseInt(br.readLine());

		String[] numsArray = numbers.split(" ");
		for (String num : numsArray) {
			int idx = Integer.parseInt(num);
			if (x > idx && arr[x - idx]) {
				total++;
			}
			arr[idx] = true;
		}

		System.out.println(total);
	}
}
