public class Programmers70129_1 {
	private static int removedZeroCount = 0;
	private static int totalConvertedCount = 0;

	public int[] solution(String s) {
		String target = s;
		while (true) {
			String removedStr = removeZero(target);
			String binaryStr = convertToBinaryNumber(removedStr);
			if (isAnswer(binaryStr)) {
				totalConvertedCount++;
				break;
			}
			totalConvertedCount++;
			target = binaryStr;
		}

		return new int[] {totalConvertedCount, removedZeroCount};
	}

	private String removeZero(String target) {
		StringBuilder result = new StringBuilder();
		StringBuilder sb = new StringBuilder(target);
		// 문자열 앞에서부터 0을 찾는다.
		for (int i = 0; i < target.length(); i++) {
			char token = sb.charAt(i);
			if (token == '0') {
				// 제거한 0의 개수를 1 늘린다.
				removedZeroCount++;
				continue;
			}
			// 0이 아닌 글자를 붙여넣는다.
			result.append(token);
		}

		return result.toString();
	}

	private String convertToBinaryNumber(String target) {
		// 문자열의 길이를 구한다.
		int length = target.length();

		// 문자열의 길이를 2진법으로 변환한다.
		return Integer.toString(length, 2);
	}

	private boolean isAnswer(String target) {
		return target.equals("1");
	}
}
