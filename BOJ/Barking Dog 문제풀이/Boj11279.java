package ps;

import java.io.*;
import java.util.*;

public class Boj11279 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((e1, e2) -> e2 - e1);
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (maxHeap.isEmpty()) {
                    sb.append(0)
                      .append('\n');
                } else {
                    int val = maxHeap.poll();
                    sb.append(val)
                      .append('\n');
                }
            } else {
                maxHeap.offer(num);
            }
        }

        System.out.println(sb);
    }
}
