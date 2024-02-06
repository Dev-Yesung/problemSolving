import java.util.ArrayList;
import java.util.List;

public class Programmers84512_2 {

	public static void main(String[] args) {
		int answer = new Programmers84512_2()
			.solution("EIO");

		System.out.println(answer);
	}

	static char[] CHARS = "AEIOU".toCharArray();
	static List<String> words = new ArrayList<>();

	public int solution(String word) {
		generate("");

		return words.indexOf(word);
	}

	private void generate(String word) {
		words.add(word);

		if (word.length() == 5) {
			return;
		}

		for (char c : CHARS) {
			generate(word + c);
		}
	}

}
