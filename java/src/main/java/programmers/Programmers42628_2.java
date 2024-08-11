package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class Programmers42628_2 {

	public int[] solution(String[] operations) {
		DoublyPriorityQueue doublyPriorityQueue = new DoublyPriorityQueue();

		for (String operation : operations) {
			String[] tokens = operation.split(" ");
			String command = tokens[0];
			String value = tokens[1];

			switch (command) {
				case "I" -> doublyPriorityQueue.add(Integer.parseInt(value));
				case "D" -> {
					if ("1".equals(value)) {
						doublyPriorityQueue.pollMaxNumber();
					}
					if ("-1".equals(value)) {
						doublyPriorityQueue.pollMinNumber();
					}
				}
			}
		}

		return new int[] {doublyPriorityQueue.peekMaxNumber(), doublyPriorityQueue.peekMinNumber()};
	}

	private static class DoublyPriorityQueue {
		private int size = 0;
		private final PriorityQueue<Integer> minPq = new PriorityQueue<>();
		private final PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

		public void add(int value) {
			minPq.offer(value);
			maxPq.offer(value);
			size++;
		}

		public void pollMaxNumber() {
			if (isEmpty()) {
				return;
			}

			maxPq.poll();
			this.size--;
			clearIfSizeIsZero();
		}

		public void pollMinNumber() {
			if (isEmpty()) {
				return;
			}

			minPq.poll();
			this.size--;
			clearIfSizeIsZero();
		}

		public Integer peekMaxNumber() {
			if (isEmpty()) {
				return 0;
			}

			return maxPq.peek();
		}

		public Integer peekMinNumber() {
			if (isEmpty()) {
				return 0;
			}

			return minPq.peek();
		}

		private boolean isEmpty() {
			return this.size == 0;
		}

		private void clearIfSizeIsZero() {
			if (this.size == 0) {
				maxPq.clear();
				minPq.clear();
			}
		}
	}
}
