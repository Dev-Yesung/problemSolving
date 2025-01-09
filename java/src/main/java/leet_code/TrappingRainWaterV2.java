package leet_code;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWaterV2 {

	public static void main(String[] args) {
		final int answer = new TrappingRainWaterV2()
			.trap(new int[] {4, 2, 0, 3, 2, 5});
		System.out.println(answer);
	}

	public int trap(int[] height) {
		int answer = 0;
		final Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
				Integer top = stack.pop();
				if (stack.isEmpty()) {
					break;
				}

				int distance = i - stack.peek() - 1;
				int waters = Math.min(height[i], height[stack.peek()]) - height[top];
				answer += distance * waters;
			}

			stack.push(i);
		}

		return answer;
	}
}
