package baekjoon;

import java.io.*;
import java.util.*;

class CollectionTest {
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        for (int num : list) {
            dq.push(num);
        }

        dq.addFirst(3);

        while (!dq.isEmpty()) {
            System.out.println(dq.poll());
        }
    }
}
