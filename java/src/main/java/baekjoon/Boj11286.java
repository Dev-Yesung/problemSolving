package baekjoon;

import java.io.*;
import java.util.*;

public class Boj11286 {

    // Comparator 관련해서 정리할 필요가 있음
    // 항상 왼쪽 원소를 기준으로 생각한다.
    // left 가 왼쪽으로 (순서가 더 앞으로) 가야 한다면 return -1 (이동 x)
    // left 가 오른쪽으로 (순서가 더 뒤로) 가야 한다면 return 1 (왼쪽에서 오른쪽으로 이동)
    // left 와 right 의 값이 같다면 return 0

    // PriorityQueue 를 생성할 때 Comparator 를 람다 형태로
    // Functional Interface 인 Comparator 로 던져줄 수 있음.

    // Integer.compareTo는 오름차순 정렬이다.
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
        return Math.abs(o1) < Math.abs(o2) ? -1
                : Math.abs(o1) > Math.abs(o2) ? 1 : o1.compareTo(o2);
//        if (Math.abs(o1) < Math.abs(o2)) {
//            return -1;
//        } else if (Math.abs(o1) > Math.abs(o2)) {
//            return 1;
//        } else {
//            return o1.compareTo(o2);
//        }
    });

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (pq.isEmpty()) {
                    sb.append(0)
                      .append('\n');
                    continue;
                }
                sb.append(pq.poll())
                  .append('\n');
                continue;
            }

            pq.add(x);
        }

        System.out.println(sb);
    }
}
