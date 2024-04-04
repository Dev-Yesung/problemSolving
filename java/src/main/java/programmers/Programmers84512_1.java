import java.util.*;

public class Programmers84512_1 {

	public static void main(String[] args) {
		int answer = new Programmers84512_1()
			.solution("EIO");

		System.out.println(answer);
	}

	static String[] elements = new String[] {"A", "E", "I", "O", "U"};
	static Map<String, Integer> map = new HashMap<>();
	static int number = 1;

	public int solution(String word) {
		// 1. A,E,I,O,U로 만들 수 있는 모든 단어 조합 Map<단어, 몇 번째> -> 재귀 가능
		for (int curr = 0; curr < 5; curr++) {
			getSeries(curr, 0, "");
		}
		// 2. map.get(word);해서 반환
		return map.get(word);
	}

	void getSeries(int curr, int length, String str) {
		if (length == 5) {
			return;
		}

		map.put(str + elements[curr], number);
		number++;

		for (int i = 0; i < 5; i++) {
			getSeries(i, length + 1, str + elements[curr]);
		}
	}

}
