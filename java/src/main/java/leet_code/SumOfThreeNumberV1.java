package leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfThreeNumberV1 {

	public static void main(String[] args) {
		List<List<Integer>> answer = new SumOfThreeNumberV1()
			.threeSum(new int[] {-1, 0, 1, 2, -1, -4});
		answer.forEach(System.out::println);
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> answer = new ArrayList<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			/* sort를 했기 때문에 가능한 방식
			 * 정렬을 했기 때문에, 일반적으로 이전 값과 이후 값은 다르다.
			 * 정렬을 하면 같은 값은 주변에 모임. 이 속성을 활용해 이전 값과 현재 값이 같으면 중복된 결과가 나오지 않도록 스킵
			 */
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length - 1; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				for (int k = j + 1; k < nums.length; k++) {
					if (k > j + 1 && nums[k] == nums[k - 1]) {
						continue;
					}
					if (nums[i] + nums[j] + nums[k] == 0) {
						answer.add(List.of(nums[i], nums[j], nums[k]));
					}
				}
			}
		}

		return answer;
	}
}
