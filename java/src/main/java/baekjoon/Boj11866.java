package baekjoon;

import java.io.*;
import java.util.*;

class Boj11866 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String[] param = br.readLine().split(" ");
        int n = Integer.parseInt(param[0]);
        int k = Integer.parseInt(param[1]);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        sb.append('<');
        int cnt = 1;
        while(!q.isEmpty()) {
            if (cnt == k) {
                sb.append(q.poll());
                if (q.size() != 0) {
                    sb.append(", ");
                }
                cnt = 1;
                continue;
            }

            q.offer(q.poll());
            cnt++;
        }
        sb.append('>');

        System.out.println(sb);
    }
}
