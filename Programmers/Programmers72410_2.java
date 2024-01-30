// 정규표현식으로 개선된 풀이
public class Programmers72410_2 {

	public static void main(String[] args) {
		String answer = new Programmers72410_2()
			.solution("...!@BaT#*..y.abcdefghijklm");
		System.out.println(answer);
	}

	public String solution(String new_id) {
		String newId = new_id;

		newId = newId.toLowerCase();
		newId = newId.replaceAll("[^a-z0-9\\-_.]", "");
		newId = newId.replaceAll("\\.+", ".");
		newId = newId.replaceAll("^\\.+|\\.+$", "");
		if (newId.isEmpty()) {
			newId = "a";
		}
		if (newId.length() >= 16) {
			newId = newId.substring(0, 15);
			newId = newId.replaceAll("\\.+$", "");
		}
		while (newId.length() < 3) {
			newId += newId.charAt(newId.length() - 1);
		}

		return newId;
	}
}
