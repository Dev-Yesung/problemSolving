import java.util.*;

// 시간복잡도가 크지만 정답은 나옴
// 1000log1000 + 1000 * 1000 = 10000 + 1000000
class Programmers42747_1 {
	public int solution(int[] citations) {
		int[] sortedArr = Arrays.stream(citations)
			.sorted()
			.toArray();

		for (int h = sortedArr.length; h >= 1; h--) {
			int count = 0;
			for (int citation : citations) {
				if (citation >= h) {
					count++;
				}
			}

			if (count >= h) {
				return h;
			}
		}

		return 0;
	}
}
