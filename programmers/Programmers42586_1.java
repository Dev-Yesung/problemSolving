import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Programmers42586_1 {

	public static void main(String[] args) {
		int[] answer1 = new Programmers42586_1()
			.solution(new int[] {93, 30, 55}, new int[] {1, 30, 5});
		int[] answer2 = new Programmers42586_1()
			.solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1});

		System.out.println(Arrays.toString(answer1));
		System.out.println(Arrays.toString(answer2));
	}

	public int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < progresses.length; i++) {
			q.offer(i);
		}

		List<Integer> result = new ArrayList<>();
		int days = 0;
		int count = 0;
		while (!q.isEmpty()) {
			int index = q.poll();
			int expiration = (int)Math.ceil((double)(100 - progresses[index]) / speeds[index]);
			if (expiration > days) {
				if (days != 0) {
					result.add(count);
					count = 0;
				}
				days = expiration;
			}
			count++;
		}
		result.add(count);

		return result.stream()
			.mapToInt(Integer::intValue)
			.toArray();
	}
}
