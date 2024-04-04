package baekjoon;

import java.io.*;
import java.util.*;

public class MergeSortEx {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int[] array;
    static int[] tmp = new int[10000001];

    public static void main(String[] args) {
        int n = sc.nextInt();
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        merge_sort(0, n);
        Arrays.stream(array).forEach(num -> sb.append(num).append('\n'));
        System.out.println(sb.toString());
    }

    private static void merge_sort(int start, int end) {
        if (start + 1 == end) {
            return;
        }

        int mid = (start + end) / 2;
        merge_sort(start, mid);
        merge_sort(mid, end);
        merge(start, end);
    }

    private static void merge(int start, int end) {
        int mid = (start + end) / 2;
        int lIdx = start;
        int rIdx = mid;
        for (int i = start; i < end; i++) {
            if (rIdx == end) {
                tmp[i] = array[lIdx++];
            } else if (lIdx == mid) {
                tmp[i] = array[rIdx++];
            } else if (array[lIdx] <= array[rIdx]) {
                tmp[i] = array[lIdx++];
            } else {
                tmp[i] = array[rIdx++];
            }
        }

        for (int i = start; i < end; i++) {
            array[i] = tmp[i];
        }
    }
}
