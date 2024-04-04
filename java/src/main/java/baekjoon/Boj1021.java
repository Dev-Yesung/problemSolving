package baekjoon;

import java.io.*;
import java.util.*;

public class Boj1021 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Integer> oriDeq = new LinkedList<>();
    static StringTokenizer st;
    static int N, M;
    static int frontCount, backCount;
    static boolean isFront;
    static int total;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();

        st = new StringTokenizer(input, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; ++i) {
            oriDeq.add(i);
        }
        // 브루트포스로 뽑아내기 가능
        input = br.readLine();
        st = new StringTokenizer(input, " ");

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            Deque<Integer> copy = new LinkedList<>(oriDeq);
            while (!copy.isEmpty()) {
                int elem = copy.pollFirst();
                if (target != elem) {
                    copy.addLast(elem);
                    frontCount++;
                    continue;
                }
                break;
            }

            copy = new LinkedList<>(oriDeq);
            while (!copy.isEmpty()) {
                int elem = copy.pollLast();
                if (target != elem) {
                    copy.addFirst(elem);
                    backCount++;
                    continue;
                } else {
                    backCount++;
                }
                break;
            }

            if (Math.min(frontCount, backCount) == frontCount) {
                isFront = true;
                total += frontCount;
            } else {
                isFront = false;
                total += backCount;
            }

            if (isFront) {
                for (int j = 0; j < frontCount; j++) {
                    int elem = oriDeq.pollFirst();
                    oriDeq.addLast(elem);
                }
                oriDeq.pollFirst();
            } else {
                for (int j = 0; j < backCount - 1; j++) {
                    int elem = oriDeq.pollLast();
                    oriDeq.addFirst(elem);
                }
                oriDeq.pollLast();
            }

            frontCount = 0;
            backCount = 0;
        }
        System.out.println(total);
    }
}
