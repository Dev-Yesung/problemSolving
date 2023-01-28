package ps;

import java.io.*;
import java.util.*;

public class Boj6198 {
	static int[] counter = new int[80_001];
	static int[] val = new int[80_001];
	static Stack<Pair<Integer, Integer>> s = new Stack<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		s.add(new Pair<>(0, Integer.MAX_VALUE));

		for(int i = 1; i <= N; i++) {
			val[i] = Integer.parseInt(br.readLine());
		}

		for (int i = N; i >= 1; i--) {
			int h = val[i];

			while (s.peek().val < h) {
				counter[i] += counter[s.peek().idx] + 1;
				s.pop();
			}

			s.add(new Pair<>(i, h));
		}

		int result = 0;
		for (int i = 1; i <= N; i++) {
			result += counter[i];
		}
		System.out.println(result);
	}

	static class Pair<L, R> {
		L idx;
		R val;
		Pair(L idx, R val) {
			this.idx = idx;
			this.val = val;
		}
	}
}
