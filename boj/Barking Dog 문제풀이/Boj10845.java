package ps;

import java.io.*;
import java.util.*;

public class Boj10845 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<Integer> q = new LinkedList<>();
    static ListIterator<Integer> iter;
    static int lastElem;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; ++i) {
            String input = br.readLine();

            st = new StringTokenizer(input, " ");
            String cmd = st.nextToken();
            int param = cmd.equals("push") ? Integer.parseInt(st.nextToken()) : 0;

            switch (cmd) {
                case "push":
                    q.add(param);
                    lastElem = param;
                    break;
                case "pop":
                    if (q.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(q.poll());
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    if (q.isEmpty()) {
                        System.out.println(1);
                        break;
                    }
                    System.out.println(0);
                    break;
                case "front":
                    if (q.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(q.peek());
                    break;
                case "back":
                    if (q.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(lastElem);
            }
        }
    }
}
