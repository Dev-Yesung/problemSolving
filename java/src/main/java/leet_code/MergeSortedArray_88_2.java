
package leet_code;

import java.util.Arrays;

// 시간복잡도 : O(m+n) -> 투 포인터로 선형 탐색 두 개를 합친 시간복잡도
public class MergeSortedArray_88_2 {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;

		while (j >= 0) {
			if (i >= 0 && nums1[i] > nums2[j]) {
				nums1[k--] = nums1[i--];
			} else {
				nums1[k--] = nums2[j--];
			}
		}
	}
}
