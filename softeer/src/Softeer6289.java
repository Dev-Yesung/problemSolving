import java.io.*;
import java.util.*;

// https://softeer.ai/practice/6289
// 깔끼하게 품 -> 인접리스트 이용해서 풀이
public class Softeer6289 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int count = 0;
		// n, m 파싱
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		// 무게 파싱
		input = br.readLine().split(" ");
		int len = input.length;
		int[] weight = new int[len + 1];
		for (int i = 0; i < len; i++) {
			weight[i + 1] = Integer.parseInt(input[i]);
		}

		// 친구관계 파싱
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i <= len; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);

			adjList.get(a).add(b);
			adjList.get(b).add(a);
		}

		// 답 찾기
		// 1번부터 리스트를 돌면서 본인의 weight와 연관관계 weight를 비교
		// 만일, 본인보다 무거운 무게가 없다면 count에 +1 아니라면 중간에 break
		for (int cur = 1; cur <= len; cur++) {
			boolean isBest = true;
			int curWeight = weight[cur];
			for (int friendIdx : adjList.get(cur)) {
				int friendWeight = weight[friendIdx];
				if (curWeight <= friendWeight) {
					isBest = false;
					break;
				}
			}

			if (isBest) {
				count++;
			}
		}

		System.out.println(count);
	}
}
