public class Programmers12917_2 {

	public static void main(String[] args) {
		String answer = new Programmers12917_2()
			.solution("Zbcdefg");

		System.out.println(answer);
	}

	public String solution(String s) {
		return s.chars()
			.boxed()
			.sorted((c1, c2) -> c2 - c1)
			.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
			.toString();
	}
}
