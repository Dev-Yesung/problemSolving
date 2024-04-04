// Sooo EZ
public class Programmers12932_1 {
	public int[] solution(long n) {
		String intToStringNumber = String.valueOf(n);
		char[] numberArray = intToStringNumber.toCharArray();
		int length = numberArray.length;
		int[] answer = new int[length];
		for (int i = 0; i < length; i++) {
			answer[length - 1 - i] = Character.getNumericValue(numberArray[i]);
		}
		return answer;
	}
}
