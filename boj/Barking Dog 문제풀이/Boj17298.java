package ps;

import java.io.*;
import java.util.*;

public class Boj17298 {

    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> result = new Stack<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        stack.add(nums[N-1]);
        result.add(-1);
        for (int i = N-2; i >= 0; i--) {
            int num = nums[i];

            while (!stack.isEmpty()) {
                if (num  < stack.peek()) {
                    result.add(stack.peek());
                    break;
                }
                stack.pop();
            }

            if (stack.isEmpty()) {
                result.add(-1);
            }

            stack.add(num);
        }

        while (!result.isEmpty()) {
            sb.append(result.pop()).append(" ");
        }

        System.out.println(sb.toString());
    }
}
