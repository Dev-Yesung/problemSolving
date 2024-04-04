import java.util.Arrays;

public class Programmers42842 {

	public static void main(String[] args) {
		int[] solution = new Programmers42842()
			.solution(24, 24);

		String answer = Arrays.toString(solution);
		System.out.println(answer);
	}

	public int[] solution(int brown, int yellow) {
		// width의 최대 길이는 (5000 - 2) / 2 = 2499
		for (int width = 3; width <= 2499; width++) {
			for (int height = 3; height <= width; height++) {
				// 둘러싼 갈색 격자의 개수
				int boundary = (width + height - 2) * 2;
				// 노란색 격자의 개수
				int center = width * height - boundary;
				if (boundary == brown && yellow == center) {
					return new int[] {width, height};
				}
			}
		}

		return null;
	}
}
