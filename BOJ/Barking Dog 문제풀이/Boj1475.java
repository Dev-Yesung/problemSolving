package ps;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Boj1475 {
	private static Scanner sc = new Scanner(System.in);
	private static int[] arr = new int[10];
	private static String roomNumber;

	public static void main(String[] args) {
		roomNumber = sc.nextLine();
		Arrays.stream(roomNumber.split("")).map(Integer::parseInt).forEach(num -> {
			arr[num]++;
		});

		double ninePlusSixAvg = (arr[6] + arr[9]) / 2.0;
		int avgCeil = (int) Math.ceil(ninePlusSixAvg);

		int maxSet = Integer.MIN_VALUE;
		for (int idx = 0; idx < 10; idx++) {
			if (idx == 6 || idx == 9) {
				continue;
			}
			if (maxSet < arr[idx]) {
				maxSet = arr[idx];
			}
		}

		maxSet = Integer.max(maxSet, avgCeil);
		System.out.println(maxSet);
	}
}
