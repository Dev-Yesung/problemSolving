package leet_code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// merge two forLoops to one
public class TwoSumV4 {

	public static void main(String[] args) {
		int[] answer = new TwoSumV4().twoSum(new int[] {2, 7, 11, 15}, 9);
		System.out.println(Arrays.toString(answer));
	}

	public int[] twoSum(int[] nums, int target) {
		// 원본 인덱스 저장
		Map<Integer, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			indexMap.put(nums[i], i);
		}

		Arrays.sort(nums);
		int leftPtr = 0;
		int rightPtr = nums.length - 1;
		while (leftPtr < rightPtr) {
			int sum = nums[leftPtr] + nums[rightPtr];
			if (sum == target) {
				return new int[] {indexMap.get(nums[leftPtr]), indexMap.get(nums[rightPtr])};
			} else if (sum > target) {
				rightPtr--;
			} else {
				leftPtr++;
			}
		}

		return null;
	}
}
