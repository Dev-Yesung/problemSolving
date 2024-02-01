package ps;

import java.io.IOException;
import java.util.PriorityQueue;

public class Boj1715_RangeTest {

    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 100_000; i++) {
            pq.add(1_000);
        }

        long result1 = 0;
        int result2 = 0;
        while (pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            result1 += num1 + num2;
            result2 += num1 + num2;
            pq.add(num1 + num2);
        }

        System.out.println("long 타입의 result1 결과 : " + result1
                                   + "\nint 타입의 result2 결과 : "
                                   + result2);
    }
}
