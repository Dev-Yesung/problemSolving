package baekjoon;

import java.io.*;
import java.util.*;

/*
o(n)으로 푸는데는 어느 정도 성공했지만 답이 틀림
-> 다른 방법의 선형 탐색이 있을 거란 생각을 해야함
-> 답을 보니 굳이 모든 값을 스택에 넣고 시작할 필요가 없음
-> 처음 생각했던 아이디어 자체가 선형 탐색과 맞지 않음
-> 이 방식대로라면 내가 생각했던 최악의 경우도 쉽게 해결됨
-> 이 방식대로면 무조건 선형 탐색일 수 밖에 없음

-> top-down 방식이 아닌 bottom-up의 관점에서도 생각해보는 습관을 길러야 한다.
-> 문제를 곧이곧대로 받아서 풀 필요는 없음 뒤집어 생각해보는 것도 필요

+a : recursion 으로는 불가능할까?
-> 불가능하다. 메모리 초과됨 50만 x 4바이트 -> 50만은 대략 2의 27승 * 4 = 2의 29승 바이트
-> 2의 9승 메가바이트 = 512메가바이트, 메모리 제한은 128메가바이트
 */

class Pair<L, R> {
    L key;
    R val;

    Pair(L key, R val) {
        this.key = key;
        this.val = val;
    }
}

public class Boj2493 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Stack<Pair<Integer, Integer>> stack = new Stack<>();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String nums = br.readLine();
        st = new StringTokenizer(nums, " ");

        // 38번 라인 답이 없을 때 출력하도록 하는 방식. 센스 있는 방식이다. 배우자!
        stack.add(new Pair<>(0, 100_000_001));
        for (int i = 1; i <= n; i++) {
            int val = Integer.parseInt(st.nextToken());

            // 입력된 타워의 레이저를 받을 가장 왼쪽의 타워를 찾는다.
            // 왼쪽에서 나온 가장 최근의 타워 높이 중 최근 값 보다 큰 타워 높이만 스택에 올라가 있도록 한다.
            while (stack.peek().val < val) {
                stack.pop();
            }

            // 현재 받은 값보다 스택의 peek에 해당하는 값이 더 크면 그 값이 레이저를 받기 때문에
            sb.append(stack.peek().key).append(' ');
            stack.add(new Pair<>(i, val));
        }

        System.out.println(sb.toString());
    }
}
