package baekjoon;

import java.io.*;
import java.util.*;

public class Boj18258 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static int lastElem;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; ++i) {
            String input = br.readLine();

            st = new StringTokenizer(input, " ");
            String cmd = st.nextToken();

            int param = -1;

            switch (cmd) {
                case "push":
                    param = Integer.parseInt(st.nextToken());
                    q.add(param);
                    lastElem = param;
                    break;
                case "pop":
                    if (q.isEmpty()) {
                        sb.append(-1).append('\n');
                        continue;
                    }
                    sb.append(q.poll()).append('\n');
                    break;
                case "size":
                    sb.append(q.size()).append('\n');
                    break;
                case "empty":
                    if (q.isEmpty()) {
                        sb.append(1).append('\n');
                        continue;
                    }
                    sb.append(0).append('\n');
                    break;
                case "front":
                    if (q.isEmpty()) {
                        sb.append(-1).append('\n');
                        continue;
                    }
                    sb.append(q.peek()).append('\n');
                    break;
                case "back":
                    if (q.isEmpty()) {
                        sb.append(-1).append('\n');
                        continue;
                    }
                    sb.append(lastElem).append('\n');
            }
        }

        System.out.println(sb.toString());
    }
}
