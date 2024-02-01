package ps;

import java.io.*;
import java.util.*;

public class Boj2164 {

    static Scanner sc = new Scanner(System.in);
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        int n = sc.nextInt();

        for (int i = 1; i <= n; ++i) {
            q.add(i);
        }

        while (q.size() != 1) {
            q.poll();
            q.add(q.poll());
        }

        System.out.println(q.peek());
    }
}
