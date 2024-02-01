package ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Boj10807 {
	private static Scanner sc = new Scanner(System.in);
	// private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int N, V;

	public static void main(String[] args) {
/*		 N = Integer.parseInt(br.readLine());
		 String[] numbers = br.readLine().split(" ");
		 V = Integer.parseInt(br.readLine());
		 long result = Arrays.stream(numbers).map(Integer::parseInt).filter(num -> num == V).count();
		 System.out.println(result);
*/
		N = sc.nextInt();
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}
		V = sc.nextInt();

		int result = 0;
		for (int num : numbers) {
			if (num == V) {
				result++;
			}
		}

		System.out.println(result);
	}
}
