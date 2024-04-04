package baekjoon;

import java.io.*;
import java.util.*;

public class Boj2504 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Character> stack = new Stack<>();
    static char before = '(';
    static boolean isError;
    static int tmp = 1;
    static int total = 0;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        for (char ch : input.toCharArray()) {
            switch (ch) {
                case '[':
                    stack.push(ch);
                    tmp *= 3;
                    break;
                case '(':
                    stack.push(ch);
                    tmp *= 2;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        isError = true;
                        break;
                    }

                    if (before == '[') {
                        total += tmp;
                    }
                    tmp /= 3;
                    stack.pop();
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isError = true;
                        break;
                    }

                    if (before == '(') {
                        total += tmp;
                    }
                    tmp /= 2;
                    stack.pop();
            }
            before = ch;

            if (isError) {
                break;
            }
        }

        if (!stack.isEmpty() || isError) {
            total = 0;
        }

        System.out.println(total);
    }

}
