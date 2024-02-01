package ps;


/*
    모범 답안 코드를 자바코드로 옮긴 것
 */
//import java.io.*;
//import java.util.*;
//
//public class Boj11652 {
//
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//    public static void main(String[] args) throws IOException {
//        long[] nums = new long[100_000];
//        int N = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < N; i++) {
//            long num = Long.parseLong(br.readLine());
//            nums[i] = num;
//        }
//        Arrays.sort(nums,0, N);
//
//        long maxVal = Long.MIN_VALUE;
//        int curCnt = 0, maxCnt = 0;
//        for (int i = 0; i < N; i++) {
//            if (i == 0 || nums[i - 1] == nums[i]) {
//                curCnt++;
//            } else {
//                if (curCnt > maxCnt) {
//                    maxCnt = curCnt;
//                    maxVal = nums[i - 1];
//
//                }
//                curCnt = 1;
//            }
//        }
//        if (curCnt > maxCnt) {
//            maxVal = nums[N - 1];
//        }
//
//        System.out.println(maxVal);
//    }
//
//}


/*
    내가 처음 짰던 코드 개선한 것
 */
//import java.io.*;
//import java.util.*;
//
//public class Boj11652 {
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//    public static void main(String[] args) throws IOException {
//        long[] nums =  new long[100_000];
//        int N = Integer.parseInt(br.readLine());
//        for (int i = 0; i < N; i++) {
//            long num = Long.parseLong(br.readLine());
//            nums[i] = num;
//        }
//
//        Arrays.sort(nums, 0, N);
//        int curSize = 0, lastSize = 0;
//        long maxVal = Long.MIN_VALUE, before = nums[0];
//        for (int i = 0; i < N; i++) {
//            if (nums[i] == before) {
//                curSize++;
//            } else {
//                if (curSize > lastSize) {
//                    maxVal = before;
//                    lastSize = curSize;
//                }
//                curSize = 1;
//            }
//            before = nums[i];
//        }
//        if (curSize > lastSize) {
//            maxVal = before;
//        }
//
//        System.out.println(maxVal);
//    }
//}


/*
    깔끔하게 처리할 수 있는 최적코드
 */

import java.io.*;
import java.util.*;

public class Boj11652 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        long[] nums = new long[100_001];
        Arrays.fill(nums, Long.MAX_VALUE);

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            nums[i] = num;
        }

        Arrays.sort(nums, 0, N);
        int curSize = 1, lastSize = 0;
        long maxVal = Long.MIN_VALUE;
        for (int i = 1; i < N; i++) {
            if (nums[i] == nums[i - 1]) {
                curSize++;
            } else {
                if (curSize > lastSize) {
                    maxVal = nums[i - 1];
                    lastSize = curSize;
                }
                curSize = 1;
            }
        }
        if (curSize > lastSize) {
            maxVal = nums[N - 1];
        }

        System.out.println(maxVal);
    }
}
