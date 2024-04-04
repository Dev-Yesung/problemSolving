package baekjoon;

import java.io.*;
import java.util.*;

public class Boj10828 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Stack<Integer> stack = new Stack<>();
    static String cmd;
    static int X;
    static int tc;
    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String input = br.readLine();

            st = new StringTokenizer(input, " ");
            cmd = st.nextToken();
            if (cmd.equals("push")) {
                X = Integer.parseInt(st.nextToken());
            }

            switch(cmd) {
                case "push":
                    stack.push(X);
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                        continue;
                    }
                    System.out.println(stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case"empty":
                    if (stack.isEmpty()) {
                        System.out.println(1);
                        continue;
                    }
                    System.out.println(0);
                    break;
                case"top":
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                        continue;
                    }
                    System.out.println(stack.peek());
            }
        }
    }
}
