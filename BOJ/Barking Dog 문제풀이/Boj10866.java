package ps;

import java.io.*;
import java.util.*;

public class Boj10866 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> deq = new LinkedList<>();
    static StringTokenizer st;
    static String cmd;
    static int param;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; ++i) {
            String input = br.readLine();

            st = new StringTokenizer(input, " ");
            cmd = st.nextToken();
            switch (cmd) {
                case "push_front":
                    param = Integer.parseInt(st.nextToken());
                    deq.addFirst(param);
                    break;
                case "push_back":
                    param = Integer.parseInt(st.nextToken());
                    deq.addLast(param);
                    break;
                case "pop_front":
                    if (deq.isEmpty()) {
                        sb.append("-1\n");
                        continue;
                    }
                    sb.append(deq.pollFirst()).append('\n');
                    break;
                case "pop_back":
                    if (deq.isEmpty()) {
                        sb.append("-1\n");
                        continue;
                    }
                    sb.append(deq.pollLast()).append('\n');
                    break;
                case "size":
                    sb.append(deq.size()).append('\n');
                    break;
                case "empty":
                    if (deq.isEmpty()) {
                        sb.append("1\n");
                        continue;
                    }
                    sb.append("0\n");
                    break;
                case "front":
                    if (deq.isEmpty()) {
                        sb.append("-1\n");
                        continue;
                    }
                    sb.append(deq.peekFirst()).append('\n');
                    break;
                case "back":
                    if (deq.isEmpty()) {
                        sb.append("-1\n");
                        continue;
                    }
                    sb.append(deq.peekLast()).append('\n');
            }
        }
        System.out.println(sb.toString());
    }
}
