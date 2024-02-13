import java.util.*;
import java.util.stream.*;

public class Programmers12917_1 {

	public static void main(String[] args) {
		String answer = new Programmers12917_1()
			.solution("Zbcdefg");

		System.out.println(answer);
	}

	public String solution(String s) {
		return Arrays.stream(s.split(""))
			.sorted((c1, c2) -> c2.charAt(0) - c1.charAt(0))
			.collect(Collectors.joining(""));
	}

}
