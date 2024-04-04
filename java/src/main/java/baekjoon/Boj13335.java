package baekjoon;

import java.io.*;
import java.util.*;

/* 1. 다리 위에 올라간 트럭이 있다면, 트럭의 위치를 1씩 이동한다.
      만일 비는 위치가 생긴다면, 0로 값을 바꾼다.

   2. 다리에 트럭을 올릴 수 있는지 확인한다.
      1) 트럭이 올라갈 수 있는 자리가 있는지 if (bridge[0] == 0) 다리에 올라갈 수 있음
      2) 자리가 있더라도 다리의 전체 하중이 가능한지 판별

   3. 모두 이동했다면, 전체시간을 +1 늘린다.

   계속 반복
*/

public class Boj13335 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] param = br.readLine().split(" ");
        int n = Integer.parseInt(param[0]);
        int w = Integer.parseInt(param[1]);
        int l = Integer.parseInt(param[2]);

        Queue<Integer> q = new LinkedList<>();
        param = br.readLine().split(" ");
        for (String t : param) {
            q.offer(Integer.parseInt(t));
        }

        int[] bridge = new int[w];
        bridge[0] = q.poll();
        int answer = 1;
        boolean isAnyTruck = true;
        int weight = bridge[0];
        while (isAnyTruck) {
            for (int i = 0; i < w; i++) {
                if (bridge[i] != 0) {
                    isAnyTruck = true;
                    break;
                }
                isAnyTruck = false;
            }

            if (!isAnyTruck) {
                continue;
            }

            for (int i = w - 1; i >= 0; i--) {
                if (i == w - 1) {
                    weight -= bridge[i];
                    bridge[i] = 0;
                    continue;
                }

                bridge[i + 1] = bridge[i];
                bridge[i] = 0;
            }

            if (!q.isEmpty()) {
                if (bridge[0] == 0 && weight + q.peek() <= l) {
                    int truck = q.poll();
                    bridge[0] = truck;
                    weight += truck;
                }
            }

            answer++;
        }

        System.out.println(answer);
    }
}
