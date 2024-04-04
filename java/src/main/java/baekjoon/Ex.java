package baekjoon;

import java.io.*;
import java.util.*;

public class Ex {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long ans = 0;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Deque<Building> s = new ArrayDeque<>();
        s.push(new Building(Integer.MAX_VALUE, 0));
        for (int i = n - 1; i >= 0; i--) {
            int num = list.get(i);

            long count1 = 0;
            long count2 = 0;
            while (num > s.peek().height) {
                count1 += s.pop().total;
                count2++;
            }

            ans += (count1 + count2);
            s.push(new Building(num, count1 + count2));
        }

        System.out.println(ans);
    }

    static class Building {
        int height;
        long total;

        Building(int height, long total) {
            this.height = height;
            this.total = total;
        }
    }
}
