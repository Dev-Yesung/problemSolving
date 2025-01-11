package leet_code;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayPartitionV1 {

	public static void main(String[] args) {
		final int answer = new ArrayPartitionV1()
			.arrayPairSum(new int[] {6, 2, 6, 5, 1, 2});
		System.out.println(answer);
	}

	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		return IntStream.range(0, nums.length)
			.filter(it -> it % 2 == 0)
			.map(it -> nums[it])
			.sum();
	}
}
