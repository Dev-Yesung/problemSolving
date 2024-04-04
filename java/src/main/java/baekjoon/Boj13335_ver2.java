package baekjoon;

import java.io.*;
import java.util.*;

/*
    https://train-validation-test.tistory.com/entry/%EB%B0%B1%EC%A4%80-13335-%ED%8A%B8%EB%9F%AD-java-Queue
    내가 처음풀었던 풀이와 차이가 크지는 않다.
    다만 이 풀이는 큐를 사용하여 구현한 코드들이 좀 더 깔끔하다.
    나는 큐의 역할을 배열이 대신해줬다.
 */

public class Boj13335_ver2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] param = br.readLine().split(" ");
        int n = Integer.parseInt(param[0]);
        int w = Integer.parseInt(param[1]);
        int l = Integer.parseInt(param[2]);

        Queue<Integer> truckQ = new LinkedList<>();
        param = br.readLine().split(" ");
        for (String t : param) {
            truckQ.offer(Integer.parseInt(t));
        }

        // 이 풀이에서 핵심은 0을 큐에 넣어
        // 더미 데이터로 활용했다는 점이다.
        // 큐를 하나씩 진행시키면서 다리가 무게를 견딜 수 있으면 트럭을 넣고
        // 못견딘다면 트럭을 넣지 말고 더미 데이터인 0을 넣는다.
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            q.add(0);
        }

        int answer = 0;
        int bridgeWeight = 0;
        while (!q.isEmpty()) {
            // 내 코드는 여기서
            // isAnyTruck이라는 변수가
            // true가 될지 false가 될지 체크해야하기 때문에
            // 시간 복잡도가 더 증가할 것이다.
            bridgeWeight -= q.poll();

            // 내가 처음 작성했던 코드는 이 부분에서
            // 배열의 데이터를 앞으로 옮기는 과정이 있어서
            // 시간 복잡도가 더 증가할 것이다.
            // 하지만 이 코드는 큐로 깔끔하게 해결했다.
            if (!truckQ.isEmpty()) {
                if (truckQ.peek() + bridgeWeight <= l) {
                    bridgeWeight += truckQ.peek();
                    q.offer(truckQ.poll());
                } else {
                    q.offer(0);
                }
            }

            answer++;
        }

        System.out.println(answer);
    }
}
