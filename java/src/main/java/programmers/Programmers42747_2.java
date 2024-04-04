import java.util.*;

// 정렬을 이용해 논리적으로 따져서 시간복잡도를 줄임
// h-index 가 성립하려면 최소 N - h 에 위치한 값이 h 보다 커야한다.
// 왜냐하면 정렬했기 때문에 N - h 에서의 값이 h보다 크다면 그 아래의 값들도 모두 만족할 것이기 때문이다.
// 따라서 시간복잡도는 NlogN + N * 1 이 된다.
class Programmers42747_2 {

	public int solution(int[] citations) {
		Arrays.sort(citations);
		for (int h = citations.length; h >= 1; h--) {
			if (isValid(citations, h)) {
				return h;
			}
		}

		return 0;
	}

	boolean isValid(int[] citations, int h) {
		int index = citations.length - h;

		return citations[index] >= h;
	}

}
