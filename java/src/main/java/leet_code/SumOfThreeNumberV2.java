package leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfThreeNumberV2 {

	public static void main(String[] args) {
		List<List<Integer>> answer = new SumOfThreeNumberV2()
			.threeSum(new int[] {-1, 0, 1, 2, -1, -4});
		answer.forEach(System.out::println);
	}

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> answer = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int leftPtr = i + 1;
			int rightPtr = nums.length - 1;
			while (leftPtr < rightPtr) {
				int sum = nums[i] + nums[leftPtr] + nums[rightPtr];
				if (sum > 0) {
					rightPtr--;
				} else if (sum < 0) {
					leftPtr++;
				} else {
					answer.add(List.of(nums[i], nums[leftPtr], nums[rightPtr]));
					while (leftPtr < rightPtr && nums[leftPtr] == nums[leftPtr + 1]) {
						leftPtr++;
					}
					while (leftPtr < rightPtr && nums[rightPtr] == nums[rightPtr - 1]) {
						rightPtr--;
					}
					leftPtr++;
					rightPtr--;
				}
			}
		}

		return answer;
	}
}
