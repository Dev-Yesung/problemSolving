package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class APSS_RecursionEx2 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		List<Integer> pickedNumbers = new ArrayList<>();

		int totalSize = sc.nextInt();
		int toPickSize = sc.nextInt();
		recursivePickUp(totalSize, pickedNumbers, toPickSize);
	}

	public static void recursivePickUp(int totalSize, List<Integer> pickedNumbers, int toPickSize) {
		if (toPickSize == 0) {
			printAll(pickedNumbers);
			return;
		}

		int smallest = 0;
		if (!pickedNumbers.isEmpty()) {
			smallest = pickedNumbers.get(pickedNumbers.size() - 1) + 1;
		}

		for (int next = smallest; next < totalSize; next++) {
			pickedNumbers.add(next);
			recursivePickUp(totalSize, pickedNumbers, toPickSize - 1);
			pickedNumbers.remove(pickedNumbers.size() - 1);
		}
	}

	private static void printAll(List<Integer> list) {
		for (int number : list) {
			System.out.print(number + " ");
		}
		System.out.println();
	}
}
