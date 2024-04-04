import java.util.*;

public class Programmers12915_1 {

	public String[] solution(String[] strings, int n) {
		return Arrays.stream(strings)
			.sorted((s1, s2) -> {
				char ch1 = s1.charAt(n);
				char ch2 = s2.charAt(n);

				if (ch1 == ch2) {
					return s1.compareTo(s2);
				}
				return ch1 - ch2;
			})
			.toArray(String[]::new);
	}

}
