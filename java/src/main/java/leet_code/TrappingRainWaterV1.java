package leet_code;

public class TrappingRainWaterV1 {

	public static void main(String[] args) {
		final int answer = new TrappingRainWaterV1()
			.trap(new int[] {4, 2, 0, 3, 2, 5});
		System.out.println(answer);
	}

	public int trap(int[] height) {
		int answer = 0;
		int leftPtr = 0;
		int rightPtr = height.length - 1;
		int leftMax = height[leftPtr];
		int rightMax = height[rightPtr];

		while (leftPtr < rightPtr) {
			leftMax = Math.max(leftMax, height[leftPtr]);
			rightMax = Math.max(rightMax, height[rightPtr]);
			if (leftMax <= rightMax) {
				answer += leftMax - height[leftPtr];
				leftPtr++;
			} else {
				answer += rightMax - height[rightPtr];
				rightPtr--;
			}
		}

		return answer;
	}
}
