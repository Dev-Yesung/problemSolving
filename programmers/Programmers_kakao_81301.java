import java.util.*;

public class Programmers_kakao_81301 {

	public int solution(String s) {
		List<String> list = initialize();
		String replaced = replace(s, list);

		return Integer.parseInt(replaced);
	}

	private String replace(String s, List<String> list) {
		for (int i = 0; i <= 9; i++) {
			String target = list.get(i);
			String replacement = String.valueOf(i);
			s = s.replaceAll(target, replacement);
		}

		return s;
	}

	private List<String> initialize() {
		List<String> list = new ArrayList<>();
		list.add("zero");
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		list.add("six");
		list.add("seven");
		list.add("eight");
		list.add("nine");

		return list;
	}
}
