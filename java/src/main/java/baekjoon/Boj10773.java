package baekjoon;

import java.io.*;
import java.util.*;

public class Boj10773 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Integer> stack = new Stack<>();
    static int K, total;

    public static void main(String[] args) throws IOException {
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; ++i) {
            int input = Integer.parseInt(br.readLine());
            if (!stack.isEmpty() && input == 0) {
                stack.pop();
                continue;
            }
            stack.push(input);
        }

        total = stack.stream().reduce(0, Integer::sum);
        System.out.println(total);
    }
}
