package baekjoon;

import java.io.*;
import java.util.*;

// 왜 그리디하게 결과 값을 얻어야만 정답인가? 허프만 코딩을 생각해보자.
// -> 데이터를 효율적으로 압축(zip, rar 등등의 포맷)할 때 사용하는 알고리즘이다.
// 이 문제의 풀이 방식이 허프만 코딩의 방식과 완전히 똑같다.
// 허프만 코딩이 최적임을 증명하는 과정에서 귀납법을 이용한다.
// N = 2일 때 이 방법이 최적임이 자명한 것을 증명하고
// N = k일 때를 최적이라고 할 때, N = k + 1에서도 최적임을 보여야 한다.
// https://hi-guten-tag.tistory.com/m/98
// https://programming119.tistory.com/75

// 여기서 허프만 코딩에 대해 모른다면 이렇게 합쳐나갈 때
// 작은 것부터 처리하는 그리디 풀이가 성립하는구나 정도로만 생각하고 넘어가자

// 여기서 나는 생각없이 자료형을 int로 제출했는데, 생각해보니 자료형의 크기를 따질 필요가 있었다.
// 하나의 카드 뭉치 속 카드의 최대 개수는 1000인데 10만개의 카드 뭉치가 모두 최대치라고 생각하고
// 이 카드의 수가 계속 축적되는 방식이된다. (1000 * 10만이 아님 이 경우는 겨우 1억임)
// 이렇게 축적되는 것이 20억 이하가 되는지 확인해봐야만 한다.

public class Boj1715 {

    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            pq.add(x);
        }

        int result = 0;
        while (pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            result += num1 + num2;
            pq.add(num1 + num2);
        }

        System.out.println(result);
    }
}
