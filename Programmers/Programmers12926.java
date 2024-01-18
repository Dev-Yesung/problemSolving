// 간단한 문제지만 아주 좋은 풀이
// 여기서 기억할 아이디어는 문자를 아스키 코드 그대로 사용하는 것이 아니라
// 0~25로 바꿔주고 offset 에 더해서 값을 구하는 방식!
public class Programmers12926 {
	public String solution(String s, int n) {
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			char pushedChar = push(c, n);
			sb.append(pushedChar);
		}

		return sb.toString();
	}

	private char push(char c, int n) {
		// isAlphabetic 메서드는 문자가 알파벳인지 아닌지 판단할 수 있는 좋은 메서드이다.
		// 기억하도록 하자.
		if (!Character.isAlphabetic(c)) {
			return c;
		}

		// offset(대문자(A) 혹은 소문자(a) 알파벳의 시작 값을 구한다.
		int offset = Character.isUpperCase(c) ? 'A' : 'a';
		// 시작값을 가지고 알파벳을 0~25로 사이의 숫자(position)로 만든다.
		int position = c - offset;
		// position 에서 n만큼 push 한다.
		// position 은 0~25 사이의 순환하는 값이므로
		// 25가 넘어가면 mod 26('Z' - 'A' + 1)로 position 값을 갱신한다.
		position = (position + n) % ('Z' - 'A' + 1);

		// position 을 offset(각 문자의 기준 값인 'A'나 'a')에 더해서 push 된 문자를 구한다.
		return (char)(offset + position);
	}
}
