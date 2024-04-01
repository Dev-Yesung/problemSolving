import java.util.LinkedList;
import java.util.Queue;

public class Programmers42583 {

	public static void main(String[] args) {
		int answer1 = new Programmers42583()
			.solution(2, 10, new int[] {7, 4, 5, 6});
		int answer2 = new Programmers42583()
			.solution(100, 100, new int[] {10});
		int answer3 = new Programmers42583()
			.solution(100, 100, new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10});

		System.out.println(answer1);
		System.out.println(answer2);
		System.out.println(answer3);
	}

	public int solution(int bridgeLength, int weight, int[] truckWeights) {
		int bridgeWeight = 0;
		Queue<Integer> bridge = new LinkedList<>();
		for (int i = 0; i < bridgeLength; i++) {
			bridge.offer(0);
		}

		int time = 0;
		int truckIndex = 0;
		while (truckIndex < truckWeights.length) {
			bridgeWeight -= bridge.poll();

			int truckWeight = truckWeights[truckIndex];
			if (bridgeWeight + truckWeight <= weight) {
				bridge.offer(truckWeight);
				bridgeWeight += truckWeight;
				truckIndex++;
			} else {
				bridge.offer(0);
			}

			time++;
		}

		while (bridgeWeight > 0) {
			bridgeWeight -= bridge.poll();
			time++;
		}

		return time;
	}
}
