public class Programmers12930 {
	public String solution(String s) {
		StringBuilder answer = new StringBuilder();
		boolean isUpper = true;
		for (char c : s.toCharArray()) {
			if (!Character.isAlphabetic(c)) {
				// 공백문자는 공백문자 그대로 들어가야 한다.
				answer.append(c);
				// 공백문자 다음은 무조건 단어의 첫 시작이므로 대문자로 변경
				isUpper = true;
			} else {
				// 처음 단어의 시작 -> 여러 번 공백 문자가 오더라도 결국 단어 시작은 대문자로 바꿔야함
				// 그 이후 소문자 -> 대문자 -> 소문자 번갈아가면서 변경하는 규칙
				// 만일 공백이 다시 나온다면 공백 이후 첫 글자는 대문자로 시작해서 대문자 -> 소문자 -> 대문자 ...
				if (isUpper) {
					answer.append(Character.toUpperCase(c));
				} else {
					answer.append(Character.toLowerCase(c));
				}
				isUpper = !isUpper;
			}
		}

		return answer.toString();
	}
}
