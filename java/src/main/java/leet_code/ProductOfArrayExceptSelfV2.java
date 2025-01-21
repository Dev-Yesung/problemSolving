package leet_code;

import java.util.Arrays;

public class ProductOfArrayExceptSelfV2 {

	public static void main(String[] args) {
		final int[] answer = new ProductOfArrayExceptSelfV2()
			.productExceptSelf(new int[] {-1, 1, 0, -3, 3});

		System.out.println(Arrays.toString(answer));
	}

	public int[] productExceptSelf(int[] nums) {
		int p = 1;
		final int[] leftProduct = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			leftProduct[i] = p;
			p *= nums[i];
		}

		p = 1;
		final int[] rightProduct = new int[nums.length];
		for (int i = nums.length - 1; i >= 0; i--) {
			rightProduct[i] = p;
			p *= nums[i];
		}

		final int[] answer = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			answer[i] = leftProduct[i] * rightProduct[i];
		}

		return answer;
	}
}
