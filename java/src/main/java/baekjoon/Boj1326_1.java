package baekjoon;

import java.io.*;
import java.util.*;

public class Boj1326_1 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int bridgeSize = Integer.parseInt(readLine());
		Bridge[] bridges = getBridges(bridgeSize);
		String[] positionToken = readLine().split(" ");
		int startIndex = Integer.parseInt(positionToken[0]);
		int endIndex = Integer.parseInt(positionToken[1]);

		int answer = Integer.MAX_VALUE;
		Queue<Position> queue = new LinkedList<>();
		queue.offer(new Position(startIndex, 0));
		while (!queue.isEmpty()) {
			Position currentPosition = queue.poll();
			int currentIndex = currentPosition.index;
			Bridge currentBridge = bridges[currentIndex];
			currentBridge.isVisited = true;

			if (currentIndex == endIndex) {
				answer = Math.min(currentPosition.jumpCount, answer);
				continue;
			}

			for (int multiplier = 1;
				 currentIndex + (currentBridge.number * multiplier) <= bridges.length - 1; multiplier++) {
				int nextIndex = currentIndex + (currentBridge.number * multiplier);
				if (bridges[nextIndex].isVisited) {
					continue;
				}

				queue.offer(new Position(nextIndex, currentPosition.jumpCount + 1));
			}
			for (int multiplier = 1; currentIndex - (currentBridge.number * multiplier) >= 1; multiplier++) {
				int nextIndex = currentIndex - (currentBridge.number * multiplier);
				if (bridges[nextIndex].isVisited) {
					continue;
				}

				queue.offer(new Position(nextIndex, currentPosition.jumpCount + 1));
			}

		}

		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	private static String readLine() throws IOException {
		return br.readLine();
	}

	private static Bridge[] getBridges(int bridgeSize) throws IOException {
		Bridge[] bridges = new Bridge[bridgeSize + 1];
		String[] numbers = readLine().split(" ");
		for (int i = 1; i <= bridgeSize; i++) {
			int number = Integer.parseInt(numbers[i - 1]);
			bridges[i] = new Bridge(number, false);
		}

		return bridges;
	}

	private static class Bridge {
		public int number;
		public boolean isVisited;

		public Bridge(int number, boolean isVisited) {
			this.number = number;
			this.isVisited = isVisited;
		}
	}

	private static class Position {
		public int index;
		public int jumpCount;

		public Position(int index, int jumpCount) {
			this.index = index;
			this.jumpCount = jumpCount;
		}
	}
}
