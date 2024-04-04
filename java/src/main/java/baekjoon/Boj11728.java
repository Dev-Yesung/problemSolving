package baekjoon;

import java.io.*;
import java.util.*;

public class Boj11728 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr1, arr2, arr3;
    static int p1, p2, p3;


    public static void main(String[] args) throws IOException {
        String size = br.readLine();
        st = new StringTokenizer(size, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr1 = new int[N];
        String nums = br.readLine();
        st = new StringTokenizer(nums, " ");
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        arr2 = new int[M];
        nums = br.readLine();
        st = new StringTokenizer(nums, " ");
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        arr3 = new int[N + M];
        while (p1 < N && p2 < M) {
            if (arr1[p1] < arr2[p2]) {
                arr3[p3] = arr1[p1];
                p1++;
            } else {
                arr3[p3] = arr2[p2];
                p2++;
            }
            p3++;
        }

        if (p1 < N) {
            while (p1 < N) {
                arr3[p3] = arr1[p1];
                p1++;
                p3++;
            }
        } else if (p2 < M) {
            while (p2 < M) {
                arr3[p3] = arr2[p2];
                p2++;
                p3++;
            }
        }

        Arrays.stream(arr3).forEach(elem -> sb.append(elem).append(' '));
        System.out.println(sb.toString());
    }
}
