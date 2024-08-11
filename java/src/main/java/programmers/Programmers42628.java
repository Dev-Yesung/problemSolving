package programmers;

import java.util.*;

public class Programmers42628 {
	private static final int COMMAND_INDEX = 0;
	private static final int NUMBER_INDEX = 1;

	public int[] solution(String[] operations) {
		PriorityQueue<Integer> maxPq = new PriorityQueue<>((a, b) -> b - a);
		PriorityQueue<Integer> minPq = new PriorityQueue<>();

		for (String operation : operations) {
			String[] tokens = operation.split(" ");

			if ("I".equals(tokens[COMMAND_INDEX])) {
				Integer number = Integer.parseInt(tokens[NUMBER_INDEX]);
				maxPq.offer(number);
				minPq.offer(number);
			}
			if ("D".equals(tokens[COMMAND_INDEX])) {
				Integer number = Integer.parseInt(tokens[NUMBER_INDEX]);
				if (!maxPq.isEmpty() && number == 1) {
					minPq.remove(maxPq.poll());
				}
				if (!minPq.isEmpty() && number == -1) {
					maxPq.remove(minPq.poll());
				}
			}
		}

		if (maxPq.isEmpty()) {
			return new int[] {0, 0};

		}

		return new int[] {maxPq.peek(), minPq.peek()};
	}
}
