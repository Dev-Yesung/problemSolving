package ps;

import java.io.*;
import java.util.*;

public class Boj1874 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] seq = new int[100_001];
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb;
    static int p1 = 1;

    static public void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int i = 1; i <= n; ++i) {
            int seqNum = Integer.parseInt(br.readLine());
            seq[i] = seqNum;
        }

        for (int i = 1; i <= n; ++i) {
            stack.push(i);
            sb.append("+\n");

            while (!stack.isEmpty() && seq[p1] == stack.peek()) {
                stack.pop();
                sb.append("-\n");
                p1++;
            }
        }

        if (stack.isEmpty()) {
            System.out.println(sb.toString());
        } else {
            System.out.println("NO");
        }
    }
}
