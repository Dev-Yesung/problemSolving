package baekjoon;

import java.io.*;
import java.util.*;

public class Boj1026 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        Integer[] arr1 = new Integer[n];
        for (int i = 0; i < input.length; i++) {
            arr1[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr1, Collections.reverseOrder());

        input = br.readLine().split(" ");
        Integer[] arr2 = new Integer[n];
        for (int i = 0; i < input.length; i++) {
            arr2[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr2);

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += arr1[i] * arr2[i];
        }

        System.out.println(result);
    }
}
