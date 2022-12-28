package ps;

import java.io.*;
import java.util.*;

public class Boj1021 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Integer> deq = new LinkedList<>();
    static StringTokenizer st;
    static int N, M;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();

        st = new StringTokenizer(input, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; ++i) {
            deq.add(i);
        }
        // 브루트포스로 뽑아내기 가능
        input = br.readLine();
        st = new StringTokenizer(input, " ");

    }
}
