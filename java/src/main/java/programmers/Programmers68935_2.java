public class Programmers68935_2 {

	public int solution(int n) {
		// 십진법 숫자를 삼진법 문자열로 변환
		String str = Integer.toString(n, 3);
		// 문자열을 뒤집음
		String reversed = new StringBuilder(str)
			.reverse()
			.toString();
		// 뒤집힌 삼진법 문자열을 십진법 숫자로 변환함
		return Integer.valueOf(reversed, 3);
	}
}
