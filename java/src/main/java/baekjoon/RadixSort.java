package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RadixSort {

    static int[] radix = new int[10];

    public static void main(String[] args) {
        int[] arr = {234, 143, 412, 679, 324, 435, 767, 453, 548, 198, 333, 311, 656, 732};
        for (int num : arr) {
            System.out.printf("%3d ", num);
        }

        int[] sortArr = doRadixSort(arr);

        System.out.println();
        for (int num : sortArr) {
            System.out.printf("%3d ", num);
        }
    }

    static int[] doRadixSort(int[] arr) {
        int maxDigit = getMaxDigit(arr);

        List<Queue<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Queue<Integer> q = new LinkedList<>();
            bucket.add(q);
        }

        // 자릿수의 개수만큼 전체적인 루프를 진행한다.
        for (int digit = 0; digit < maxDigit; digit++) {
            for (int num : arr) {
                // 자리수 구하기 -> modulo 연산까지 진행해서 확실하게 index 를 구한다.
                int bucketIdx = (num / (int) Math.pow(10, digit)) % 10;
                // 버킷에 인덱스를 넣으면서 정렬이 진행됨
                bucket.get(bucketIdx).add(num);
            }
            int arrIdx = 0;
            for (int i = 0; i < 10; i++) {
                // 자리수마다 버킷에 값을 넣은 후 0번 버킷부터 빼서 배열에 넣으면 정렬이됨
                Queue<Integer> q = bucket.get(i);
                int qSize = q.size();
                for (int j = 0; j < qSize; j++) {
                    arr[arrIdx] = q.poll();
                    arrIdx++;
                }
            }
        }
        return arr;
    }

    static int getMaxDigit(int[] arr) {
        int maxDigit = 0;
        for (int num : arr) {
            int digit = (int) Math.log10((double) num) + 1;
            if (digit > maxDigit) {
                maxDigit = digit;
            }
        }
        return maxDigit;
    }
}
