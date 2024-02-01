import java.io.*;
import java.util.*;

// https://softeer.ai/practice/6294
// 성적평균 -> 대표적인 부분합 문제
public class Softeer6294 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] values = br.readLine().split(" ");
		int n = Integer.parseInt(values[0]);
		int k = Integer.parseInt(values[1]);

		values = br.readLine().split(" ");
		int[] points = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			points[i] = Integer.parseInt(values[i - 1]) + points[i - 1];
		}

		for (int i = 0; i < k; i++) {
			values = br.readLine().split(" ");
			int a = Integer.parseInt(values[0]);
			int b = Integer.parseInt(values[1]);

			int range = b - a + 1;
			int total = points[b] - points[a - 1];

			double avg = total / (double)range;
			String answer = String.format("%.02f", avg);
			System.out.println(answer);
		}
	}
}
