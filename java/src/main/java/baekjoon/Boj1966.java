package baekjoon;

import java.io.*;
import java.util.*;

class Boj1966 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Docs> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            String[] param = br.readLine().split(" ");
            int n = Integer.parseInt(param[0]), m = Integer.parseInt(param[1]);
            String[] p = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int priority = Integer.parseInt(p[j]);
                q.add(new Docs(j, priority));
            }

            int count = 0;
            while (!q.isEmpty()) {
                Docs cur = q.get(0);

                boolean isHigh = false;
                for (int k = 0; k < q.size(); k++) {
                    if (cur.priority < q.get(k).priority) {
                        isHigh = true;
                        break;
                    }
                }

                q.remove(0);
                if (isHigh) {
                    q.add(cur);
                } else {
                    count++;
                    if (cur.idx == m) {
                        break;
                    }
                }
            }

            sb.append(count).append('\n');
            q.clear();
        }

        System.out.print(sb);
    }

    static class Docs {
        int idx;
        int priority;

        Docs(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
}
