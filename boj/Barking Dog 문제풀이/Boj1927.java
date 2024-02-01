package ps;

import java.io.*;
import java.util.*;

public class Boj1927 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (pq.isEmpty()) {
                    sb.append(0)
                      .append('\n');
                    continue;
                }
                sb.append(pq.poll())
                  .append('\n');
                continue;
            }

            pq.add(num);
        }

        System.out.println(sb);
    }
}
