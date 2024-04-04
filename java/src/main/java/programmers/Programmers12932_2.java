// 다른 풀이
public class Programmers12932_2 {
	public int[] solution(long n) {
		String longToStr = Long.toString(n);
		String reversedStr = new StringBuilder(longToStr)
			.reverse()
			.toString();
		char[] charArray = reversedStr.toCharArray();

		int length = charArray.length;
		int[] answer = new int[length];
		for (int i = 0; i < length; i++) {
			answer[i] = charArray[i] - '0';
		}

		return answer;
	}
}
