
package leet_code;

import java.util.Arrays;

// 시간복잡도 : O((m+n)log(m+n))
// -> 라이브러리의 정렬 방식은 Dual-Pivot Quick sort로
// -> Quick sort의 한 종류이기 때문에 nlogn의 시간복잡도를 가진다.
public class MergeSortedArray_88_1 {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		for (int j = 0, i = m; j < n; j++) {
			nums1[i] = nums2[j];
			i++;
		}
		Arrays.sort(nums1);
	}
}
