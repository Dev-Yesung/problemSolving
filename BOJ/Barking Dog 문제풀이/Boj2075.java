package ps;

import java.io.*;
import java.util.*;

// 우선순위 큐의 특징을 잘 파악하면 된다.
// 우선순위 큐는 poll을 하게되면 결국 정렬 순서대로 원소가 빠져나온다.
// 다만 원소가 들어갈 때마다 정렬을 하는 것이 아니라.
// 원소가 들어가면서 우선순위에 있는 원소를 탑으로 보내기 때문에
// 시간복잡도가 O(lgN)으로 아주 작음
// 만일 원소가 들어올 때마다 정렬을하면 O(NlgN)의 시간이 계속 누적됨

public class Boj2075 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            Arrays.stream(line).mapToInt(Integer::valueOf).forEach(pq::add);

            while (pq.size() > n) {
                pq.poll();
            }
        }
        int ans = pq.peek();
        System.out.println(ans);
    }
}
