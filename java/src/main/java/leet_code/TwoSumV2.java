package leet_code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// time complexity improved
// O(N^2) > O(N)
public class TwoSumV2 {

	public static void main(String[] args) {
		int[] answer = new TwoSumV2().twoSum(new int[] {2, 7, 11, 15}, 9);
		System.out.println(Arrays.toString(answer));
	}

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> numsMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			numsMap.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			if (numsMap.containsKey(target - nums[i]) && i != numsMap.get(target - nums[i])) {
				return new int[] {i, numsMap.get(target - nums[i])};
			}
		}

		return null;
	}
}
