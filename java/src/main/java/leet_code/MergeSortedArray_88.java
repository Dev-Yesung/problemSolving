package leet_code;

import java.util.*;

public class MergeSortedArray_88 {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		List<Integer> orderedNums = new ArrayList<>();
		int p1 = 0;
		int p2 = 0;
		while (true) {
			if (p1 == m || p2 == n) {
				break;
			}

			int num1 = nums1[p1];
			int num2 = nums2[p2];
			if (num1 <= num2) {
				orderedNums.add(num1);
				p1++;
			} else {
				orderedNums.add(num2);
				p2++;
			}
		}

		if (p1 == m) {
			for (int i = p2; i < n; i++) {
				orderedNums.add(nums2[i]);
			}
		} else {
			for (int i = p1; i < m; i++) {
				orderedNums.add(nums1[i]);
			}
		}

		for (int i = 0; i < m + n; i++) {
			nums1[i] = orderedNums.get(i);
		}
	}
}
