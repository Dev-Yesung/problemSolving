package leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ArrayPartitionV2 {

	public static void main(String[] args) {
		final int answer = new ArrayPartitionV2()
			.arrayPairSum(new int[] {6, 2, 6, 5, 1, 2});
		System.out.println(answer);
	}

	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int answer = 0;
		final List<Integer> pair = new ArrayList<>();
		for (int num : nums) {
			pair.add(num);
			if (pair.size() == 2) {
				answer += Collections.min(pair);
				pair.clear();
			}
		}

		return answer;
	}
}
