public class Programmers70129_2 {

	public int[] solution(String s) {
		// 우리가 필요한 건 0을 제거 한 후 길이가 1인지 확인하는 것
		// 2진수로 변환했을 때 1이 되는 건 길이가 1일때 밖에 없음
		int loop = 0;
		int removed = 0;
		while (!s.equals("1")) {
			// 0의 개수를 센다.
			int zeros = countZeros(s);
			// 변환 횟수와 제거된 0의 개수 업데이트
			loop += 1;
			removed += zeros;

			// 전체 길이에서 0의 개수를 빼면 변환된 길이가 나옴
			int ones = s.length() - zeros;
			// 길이를 2진수로 변환
			// 만일 ones가 1이라면 s == 1일 것이다(유일함)
			// ones가 1이 아니라면 변환과정을 거쳐야 함
			s = Integer.toString(ones, 2);
		}

		return new int[] {loop, removed};
	}

	private int countZeros(String s) {
		int zeros = 0;
		for (char c : s.toCharArray()) {
			if (c == '0') {
				zeros++;
			}
		}

		return zeros;
	}
}
