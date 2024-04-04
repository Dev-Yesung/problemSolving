package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Boj2577 {
	private static int[] arr = new int[10];
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int result = 1;
		for (int i = 0; i < 3; i++) {
			result *= sc.nextInt();
		}

		//		String strNumber = String.valueOf(result);
		//		char[] numChar = strNumber.toCharArray();
		//		for (char num : numChar) {
		//			int index =	num - '0';
		//			arr[index]++;
		//		}
		String strNumber = String.valueOf(result);
		Arrays.stream(strNumber.split("")).map(Integer::parseInt).forEach(num -> arr[num]++);

		for (int count : arr) {
			System.out.println(count);
		}
	}
}
