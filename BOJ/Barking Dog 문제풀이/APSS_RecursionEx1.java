package ps;

import java.util.Scanner;

public class APSS_RecursionEx1 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();

		System.out.println(sum(n));
		System.out.println(recursiveSum(n));
	}

	public static int sum(int n) {
		int ret = 0;
		for (int i = 0; i <= n; i++) {
			ret += i;
		}
		return ret;
	}

	public static int recursiveSum(int n) {
		if (n == 1) {
			return 1;
		}
		return n + recursiveSum(n - 1);
	}
}
