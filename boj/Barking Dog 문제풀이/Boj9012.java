package ps;

import java.io.*;
import java.util.*;

public class Boj9012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            Stack<Character> stack = new Stack<>();
            boolean isNo = false;
            String ps = br.readLine();
            for (char ch : ps.toCharArray()) {
                switch (ch) {
                    case '(':
                        stack.add(ch);
                        break;
                    case ')':
                        if (!stack.isEmpty()) {
                            if (stack.peek() == '(') {
                                stack.pop();
                            } else {
                                isNo = true;
                            }
                        } else {
                            isNo = true;
                        }
                }

                if (isNo) {
                    break;
                }
            }

            if (!stack.isEmpty() || isNo) {
                sb.append("NO").append('\n');
            } else {
                sb.append("YES").append('\n');
            }
        }

        System.out.println(sb.toString());
    }
}
