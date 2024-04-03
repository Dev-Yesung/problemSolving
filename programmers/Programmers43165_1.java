public class Programmers43165_1 {

	public static void main(String[] args) {
		int answer1 = new Programmers43165_1()
			.solution(new int[] {1, 1, 1, 1, 1}, 3);
		int answer2 = new Programmers43165_1()
			.solution(new int[] {4, 1, 2, 1}, 4);

		System.out.println(answer1);
		System.out.println(answer2);
	}

	private static int answer = 0;

	public int solution(int[] numbers, int target) {
		calculate(numbers, target, 0, 0);

		return answer;
	}

	private void calculate(int[] numbers, int target, int idx, int total) {
		if (idx == numbers.length) {
			if (total == target) {
				answer++;
			}
			return;
		}

		calculate(numbers, target, idx + 1, total + numbers[idx]);
		calculate(numbers, target, idx + 1, total - numbers[idx]);
	}
}
