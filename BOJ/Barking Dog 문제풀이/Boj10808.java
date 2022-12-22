package ps;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Boj10808 {
	private static String S;
	private static int[] arr = new int[200];
	private static Scanner scanner = new Scanner(System.in);
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		S = scanner.nextLine();

		//firstSolution();
		streamSolution();
		printAll();
	}

	public static void firstSolution() {
		for (char ch : S.toCharArray()) {
			arr[ch]++;
		}
	}

	public static void streamSolution() {
		S.chars().forEach(ch -> arr[ch]++);
	}

	public static void printAll() throws IOException {
		for (int i = 97; i <= 122; i++) {
			bw.write(arr[i] + " ");
		}
		bw.newLine();
		bw.flush();
		bw.close();
	}
}
