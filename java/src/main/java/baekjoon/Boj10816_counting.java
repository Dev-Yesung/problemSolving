package baekjoon;

import java.io.*;
import java.util.*;

public class Boj10816_counting {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] counting = new int[20_000_001];

    public static void main(String[] args) throws IOException {
        Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] cards = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        int[] nums = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        Arrays.stream(cards).forEach(num -> counting[num + 10_000_000]++);
        Arrays.stream(nums).forEach(num -> sb.append(counting[num + 10_000_000]).append(' '));
        System.out.println(sb);
    }
}
