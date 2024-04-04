package baekjoon;

import java.io.*;
import java.util.*;

public class Boj4949 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Stack<Character> stack;
    static String lines;
    static boolean isNo;
    static boolean isEnd;

    public static void main(String[] args) throws IOException {
        while (((lines = br.readLine()).length() != 1) && (lines.charAt(0) != '.')) {
            stack = new Stack<>();
            for (char ch : lines.toCharArray()) {
                switch (ch) {
                    case '.':
                        isEnd = true;
                        break;
                    case '[':
                        stack.add(ch);
                        break;
                    case '(':
                        stack.add(ch);
                        break;
                    case ']':
                        if (!stack.isEmpty()) {
                            if (stack.peek() == '[') {
                                stack.pop();
                            } else {
                                isNo = true;
                            }
                        } else {
                            isNo = true;
                        }
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

                if (isEnd || isNo) {
                    break;
                }
            }

            if (!stack.isEmpty()) {
                isNo = true;
            }

            if (isNo) {
                sb.append("no").append('\n');
            } else {
                sb.append("yes").append('\n');
            }

            isNo = false;
            isEnd = false;
        }

        System.out.println(sb.toString());
    }
}
