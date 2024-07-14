package programmers;

import java.util.*;

public class Programmers43163 {

	public int solution(String begin, String target, String[] words) {
		if (!Arrays.asList(words).contains(target)) {
			return 0;
		}

		boolean[] isVisited = new boolean[words.length];
		Queue<State> queue = new LinkedList<>();
		queue.offer(new State(begin, 0));

		while (!queue.isEmpty()) {
			State state = queue.poll();
			if (state.word.equals(target)) {
				return state.step;
			}

			for (int i = 0; i < words.length; i++) {
				String next = words[i];
				if (!isConvertable(state.word, next)) {
					continue;
				}

				if (isVisited[i]) {
					continue;
				}

				isVisited[i] = true;
				queue.offer(new State(next, state.step + 1));
			}
		}

		return 0;
	}

	private boolean isConvertable(String src, String dst) {
		char[] srcArray = src.toCharArray();
		char[] dstArray = dst.toCharArray();

		int diff = 0;
		for (int i = 0; i < srcArray.length; i++) {
			if (srcArray[i] != dstArray[i]) {
				diff++;
			}
		}

		return diff == 1;
	}

	private static class State {
		public final String word;
		public final int step;

		public State(String word, int step) {
			this.word = word;
			this.step = step;
		}
	}
}
