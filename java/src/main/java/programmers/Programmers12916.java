public class Programmers12916 {
	boolean solution(String s) {
		s = s.toLowerCase();
		int ps = s.length() - s.replace("p", "").length();
		int py = s.length() - s.replace("y", "").length();

		return ps == py;
	}
}
