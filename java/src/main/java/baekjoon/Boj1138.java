package baekjoon;

import java.io.*;
import java.util.*;

class Boj1138 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> s = new ArrayDeque<>();
    static Deque<Integer> t = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] param = br.readLine().split(" ");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(param[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            int fore = s.size();

            if (arr[i] != fore) {
                for (int j = 0; j < fore - arr[i]; j++) {
                    t.push(s.pop());
                }

                s.push(i + 1);
                while (!t.isEmpty()) {
                    s.push(t.pop());
                }

                continue;
            }

            s.push(i + 1);
        }

        while (!s.isEmpty()) {
            sb.append(s.removeLast())
                    .append(' ');
        }

        System.out.println(sb);
    }
}
