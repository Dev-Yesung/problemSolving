public class Programmers12918_1 {
	public boolean solution(String s) {
		boolean isValidLength = checkLength(s);
		boolean isOnlyNumbers = checkOnlyNumbers(s);

		return isValidLength && isOnlyNumbers;
	}

	private boolean checkLength(String s) {
		return s.length() == 4 || s.length() == 6;
	}

	private boolean checkOnlyNumbers(String s) {
		for (char c : s.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}
}
