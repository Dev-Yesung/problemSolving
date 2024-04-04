// 정규표현식으로 개선된 풀이
public class Programmers72410_2 {

	public static void main(String[] args) {
		String answer = new Programmers72410_2()
			.solution("...!@BaT#*..y.abcdefghijklm");
		System.out.println(answer);
	}

	public String solution(String new_id) {
		String newId = new_id;

		newId = newId.toLowerCase();
		/*
			역슬래시를 두번 쓰는 이유는 두번째 역슬래시를 이스케이프 시퀀스로 이해하게 만들기 위해서이다.
			정규표현식에서 [] 안에서 '-'는 특수 문자(정규표현식 패턴)이기 때문에
			그냥 문자로 인식하게 하려면 이스케이프 시퀀스가 필요하다.
		 */
		/*
			반면 마침표는 원래 정규표현식의 패턴이지만 []에서는 이스케이프 시퀀스가 필요없다.
			왜냐하면 []패턴은 '내부의 문자 중 하나'라는 의미이기 때문에 마침표가 문자 취급받는다.
			반면 '-'은 원래 일반 문자이지만 []안에서 특수 문자로 취급 받아서 이스케이프 시퀀스가 필요했던 것이다.
		 */
		// 해석 : a-z, 0-9, -, _, .를 제외한 문자열 패턴을 모두 제거한다.
		// [] 안에서 ^ 문자는 제외를 의미한다. 반면 [] 밖에서는 문자열의 시작을 나타내는 엥커 메타문자이다.
		newId = newId.replaceAll("[^a-z0-9\\-_.]", "");
		// 해석 : 1회 이상 등장(+ 예약어)하는 마침표 글자를 마침표 하나로 변환한다.
		newId = newId.replaceAll("\\.+", ".");
		// 해석 : 마침표 글자가 글자 처음 (^)에 1회 이상 등장하거나 글자 마지막($)에 1회 이상 등장하면 제거
		// $는 정규표현식에서 문자열의 마지막 부분을 나타내는 엥커 메타문자이다.
		newId = newId.replaceAll("^\\.+|\\.+$", "");
		if (newId.isEmpty()) {
			newId = "a";
		}
		if (newId.length() >= 16) {
			newId = newId.substring(0, 15);
			// 문자열 마지막에 마침표가 1개이상 나타나면 제거한다.
			newId = newId.replaceAll("\\.+$", "");
		}
		while (newId.length() < 3) {
			newId += newId.charAt(newId.length() - 1);
		}

		return newId;
	}
}
