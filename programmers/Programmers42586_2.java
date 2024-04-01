import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers42586_2 {

	public static void main(String[] args) {
		int[] answer1 = new Programmers42586_2()
			.solution(new int[] {93, 30, 55}, new int[] {1, 30, 5});
		int[] answer2 = new Programmers42586_2()
			.solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1});

		System.out.println(Arrays.toString(answer1));
		System.out.println(Arrays.toString(answer2));
	}

	public int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> q = new LinkedList<>();
		for (int progress : progresses) {
			q.offer(progress);
		}

		int idx = 0;
		int day = 1;
		int[] answer = new int[101];
		while (!q.isEmpty()) {
			int progress = q.poll();
			while (progress + (speeds[idx] * day) < 100) {
				day++;
			}
			answer[day] += 1;
			idx++;
		}

		return Arrays.stream(answer)
			.filter(count -> count != 0)
			.toArray();
	}
}
