// 문자열을 다루는 문제
// https://school.programmers.co.kr/learn/courses/30/lessons/72410
// 별로 안어려웠음 -> 정규표현식을 썼다면, 더 빠르게 풀 수 있을 거라 생각은 함
public class Programmers72410_1 {
	public static void main(String[] args) {
		String answer = new Programmers72410_1()
			.solution("...!@BaT#*..y.abcdefghijklm");
		System.out.println(answer);
	}

	public String solution(String new_id) {
		return getNewId(new_id);
	}

	private String getNewId(String id) {
		String newId = id;
		newId = convertToLowerCase(newId);
		newId = removeNoValidCharacter(newId);
		newId = convertPeriodDoubleToSigle(newId);
		newId = removeStartOrEndPeriod(newId);
		newId = appendAIfEmptyId(newId);
		newId = removeIfIdLengthIsOver16(newId);
		newId = appendIfIdLengthIsUnder2(newId);

		return newId;
	}

	private String convertToLowerCase(String id) {
		return id.toLowerCase();
	}

	private String removeNoValidCharacter(String id) {
		StringBuilder sb = new StringBuilder();
		for (char ch : id.toCharArray()) {
			if (ch >= 'a' && ch <= 'z') {
				sb.append(ch);
			}
			if (ch >= '0' && ch <= '9') {
				sb.append(ch);
			}
			if (ch == '-' || ch == '_' || ch =='.') {
				sb.append(ch);
			}
		}

		return sb.toString();
	}

	private String convertPeriodDoubleToSigle(String id) {
		String target = id;
		boolean isExist = true;
		while (isExist) {
			String replaced = target.replace("..", ".");
			if (replaced.equals(target)) {
				isExist = false;
			}
			target = replaced;
		}

		return target;
	}

	private String removeStartOrEndPeriod(String id) {
		String target = id;
		if (target.startsWith(".")) {
			target = target.substring(1);
		}
		if (target.endsWith(".")) {
			target = target.substring(0, target.length() - 1);
		}

		return target;
	}

	private String appendAIfEmptyId(String id) {
		String appended = id;
		if (appended.equals("")) {
			appended = appended.concat("a");
		}

		return appended;
	}

	private String removeIfIdLengthIsOver16(String id) {
		if (id.length() >= 16) {
			String target = id.substring(0, 15);

			return removeStartOrEndPeriod(target);
		}

		return id;
	}

	private String appendIfIdLengthIsUnder2(String id) {
		if (id.length() <= 2) {
			StringBuilder sb = new StringBuilder(id);
			char ch = sb.charAt(id.length() - 1);
			while (sb.length() != 3) {
				sb.append(ch);
			}

			return sb.toString();
		}

		return id;
	}
}
