public class Programmers68935_1 {

	public int solution(int n) {
		// 십진법 숫자인 n을 삼진법 문자열로 바꿔줌
		String str = Integer.toString(n, 3);

		// 문자열을 뒤쪽에 0을 제거하고 문자열을 뒤집음
		int startIdx = 0;
		char[] reverse = str.toCharArray();
		for (int i = reverse.length - 1; i >= 0; i--) {
			if (reverse[i] != '0') {
				startIdx = i;
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = startIdx; i >= 0; i--) {
			sb.append(reverse[i]);
		}

		// 뒤집은 삼진법 문자열을 10진법 정수로 변환하여 반환
		return Integer.parseInt(sb.toString(), 3);
	}
}
