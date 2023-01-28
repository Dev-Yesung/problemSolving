package ps;

import java.io.*;
import java.util.*;

/*
    레이저에 의해 잘린 막대의 개수를 세는 로직이 어색하다.
    -> 다음의 블로그 코드를 참조 : https://steady-coding.tistory.com/10

    요약하면, ')'가 나왔을 때, 전에 나온 문자가 '('라면 현재 스택에 들어가 있는 크기만큼 결과값에 더하면 되고
    전에 나온 문자가 ')'라면 결과값에 +1만 해주면 된다.
    왜냐하면 전에 나온 문자가 ')'라는 말은 막대 하나를 의미하고 레이저에 의해 막대 하나의 끝 부분이 잘렸다는 것이 표현된다.
 */

public class Boj10799 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Character> stack = new Stack<>();
    /*
        static int[] razor = new int[50001];
        static int ptr = 1;
    */
    static char bf;
    static int total;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        for (char ch : input.toCharArray()) {
            switch (ch) {
                case '(':
                    stack.add(ch);
                    bf = ch;
//                    ptr++;
                    break;
                case ')':
                    stack.pop();
                    if (bf == '(') {
//                        ptr--;
//                        for (int i = 1; i <= ptr; i++) {
//                            razor[i]++;
//                        }
                        total += stack.size();
                    } else {
//                        total += (razor[ptr] + 1);
//                        razor[ptr] = 0;
//                        ptr--;
                        total += 1;
                    }
                    bf = ch;
            }
        }
        System.out.println(total);
    }
}
