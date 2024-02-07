import java.util.*;

public class Programmers42840_1 {

	public static void main(String[] args) {
		int[] answer = new Programmers42840_1()
			.solution(new int[] {1, 3, 2, 4, 2});

		String ans = Arrays.toString(answer);
		System.out.println(ans);
	}

	static int[] p1 = new int[] {1, 2, 3, 4, 5};
	static int[] p2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
	static int[] p3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

	public int[] solution(int[] answers) {
		int[] counter = countAnswers(answers);

		return getAnswer(counter);
	}

	int[] getAnswer(int[] counter) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 3; i++) {
			max = Math.max(max, counter[i]);
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			if (counter[i] == max) {
				list.add(i);
			}
		}

		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i) + 1;
		}

		return answer;
	}

	int[] countAnswers(int[] answers) {
		int[] counter = new int[3];
		int idx1 = 0;
		int idx2 = 0;
		int idx3 = 0;
		for (int answer : answers) {
			if (p1[idx1] == answer) {
				counter[0]++;
			}
			if (p2[idx2] == answer) {
				counter[1]++;
			}
			if (p3[idx3] == answer) {
				counter[2]++;
			}
			idx1 = (idx1 + 1) % 5;
			idx2 = (idx2 + 1) % 8;
			idx3 = (idx3 + 1) % 10;
		}

		return counter;
	}
}
