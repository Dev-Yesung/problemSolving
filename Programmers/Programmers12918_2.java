public class Programmers12918_2 {
	// 정규표현식을 이용한 풀이
	public boolean solution(String s) {
		// 0부터 9까지 4개를 포함하거나 6개를 포함하는지 검사(matches)
		return s.matches("[0-9]{4}|[0-9]{6}");
	}
}
