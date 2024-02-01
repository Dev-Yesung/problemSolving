package ps;

import java.io.*;
import java.util.*;

// 바킹독 야매연결리스트 자바버전
public class Boj1406_ver2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] prev = new int[600_001];
	static int[] next = new int[600_001];
	static Character[] data = new Character[600_001];

	// 새로 삽입될 노드의 위치
	static int unused = 1;
	// 노드를 가리키는 커서의 위치
	static int cursor = 1;

	public static void main(String[] args) throws IOException {
		Arrays.fill(prev, -1);
		Arrays.fill(next, -1);
		Arrays.fill(data, null);

		String input = br.readLine();
		for (int i = 0; i < input.length(); ++i) {
			next[i] = unused;
			prev[unused] = i;
			data[unused] = input.charAt(i);
			unused++;
		}
		// 맨 뒤로 커서를 변경
		cursor = unused - 1;

		int counter = Integer.parseInt(br.readLine());
		for (int i = 0; i < counter; i++) {
			String[] cmd = br.readLine().split(" ");
			switch (cmd[0]) {
				case "L":
					if (prev[cursor] != -1) {
						cursor = prev[cursor];
					}
					break;
				case "D":
					if (next[cursor] != -1) {
						cursor = next[cursor];
					}
					break;
				case "B":
					if (cursor != 0) {
						if (next[cursor] == -1) {
							cursor = prev[cursor];
							next[cursor] = -1;
						} else {
							prev[next[cursor]] = prev[cursor];
							next[prev[cursor]] = next[cursor];
							cursor = prev[cursor];
						}
					}
					break;
				case "P":
					next[unused] = next[cursor];
					next[cursor] = unused;
					prev[unused] = cursor;
					data[unused] = cmd[1].charAt(0);
					cursor = unused;
					unused++;
			}
		}

		printAll();
	}

	static void printAll() {
		StringBuilder sb = new StringBuilder();

		int iter = 0;
		while (iter != -1) {
			if (data[iter] != null) {
				sb.append(data[iter]);
			}
			iter = next[iter];
		}
		System.out.println(sb.toString());
	}
}
