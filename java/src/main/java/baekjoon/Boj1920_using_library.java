package baekjoon;

import java.io.*;
import java.util.*;

public class Boj1920_using_library {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] a = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        int[] nums = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(a);
        Arrays.stream(nums).forEach(target -> {
            int idx = Arrays.binarySearch(a, target);
            if (idx >= 0) {
                sb.append(1)
                  .append('\n');
            } else {
                sb.append(0)
                  .append('\n');
            }
        });

        System.out.print(sb);
    }
}
