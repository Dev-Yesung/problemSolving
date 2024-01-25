import java.util.ArrayList;
import java.util.List;

public class Programmers60057 {

	public static void main(String[] args) {
		int answer = new Programmers60057()
			.solution("aabbaccc");

		System.out.println(answer);
	}

	public int solution(String s) {
		// 가장 짧은 압축 문자열의 길이를 담을 min 변수를 선언
		int min = Integer.MAX_VALUE;
		// 자를 문자열의 길이를 반복문으로 설정
		for (int length = 1; length <= s.length(); length++) {
			// 문자열 압축 후 가장 짧은 길이를 선택
			String compressed = compress(s, length);
			int compressedLength = compressed.length();
			min = Math.min(compressedLength, min);
		}

		return min;
	}

	// 문자열을 압축하고 압축된 문자열의 길이를 반환하는 메서드
	private String compress(String source, int length) {
		StringBuilder sb = new StringBuilder();

		String last = "";
		int count = 0;
		List<String> tokens = split(source, length);
		for (String token : tokens) {
			// 압축 문자열 구성
			if (token.equals(last)) {
				count++;
			} else {
				// 새로운 토큰 등장 처리
				if (count > 1) {
					sb.append(count);
				}
				sb.append(last);
				last = token;
				count = 1;
			}
		}

		if (count > 1) {
			sb.append(count);
		}
		sb.append(last);

		return sb.toString();
	}

	// length의 길이씩 문자열을 잘라주는 메서드
	// 내 코드와의 차이점 -> 자르는 단위의 길이로 한 번에 자른 문자열들을 찾음
	private List<String> split(String source, int length) {
		List<String> tokens = new ArrayList<>();
		for (int startIdx = 0; startIdx < source.length(); startIdx += length) {
			int endIdx = startIdx + length;
			if (endIdx > source.length()) {
				endIdx = source.length();
			}
			String token = source.substring(startIdx, endIdx);
			tokens.add(token);
		}

		return tokens;
	}
}
