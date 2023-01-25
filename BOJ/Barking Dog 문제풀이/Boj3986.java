package ps;

import java.io.*;
import java.util.*;

/*
    선형시간 안에 문제를 해결하기 + 글자마다 짝을 맞춰줘야 함
    교차하지 않을 때 좋은단어가 된다는 것을 생각했을 때, 교차하지 않는 경우는 다음과 같다.
    AABB
    ABBA
    ABBABB
    최근에 읽은 글자와 이전에 읽은 글자가 가장 빠르게 짝을 이룰 때, 줄을 그어도 교차하지 않기 때문에
    선형탐색을 하면서 현재 읽고 있는 글자와 가장 최근에 나온 글자를 비교할 수 있는 가장 쉬운 방법은
    스택을 이용해 구현하는 것이라고 생각했다. 물론 링크드 리스트를 이용하여 포인팅하는 방법도 있지만
    결국 원리는 같음
 */

public class Boj3986 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int goodWord = 0;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            Stack<Character> stack = new Stack<>();
            stack.push(word.charAt(0));
            for (int j = 1; j < word.length(); j++) {
                if (!stack.isEmpty() && stack.peek() == word.charAt(j)) {
                    stack.pop();
                    continue;
                }
                stack.push(word.charAt(j));
            }

            if (stack.isEmpty()) {
                goodWord++;
            }
        }

        System.out.println(goodWord);
    }
}
