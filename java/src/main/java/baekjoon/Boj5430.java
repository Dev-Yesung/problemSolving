package baekjoon;

import java.io.*;
import java.util.*;

public class Boj5430 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static List<String> cmd = new LinkedList<>();
    static Deque<Integer> deq = new LinkedList<>();
    static boolean isRear;
    static boolean isError;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] p = br.readLine().split("");
            cmd.addAll(Arrays.asList(p));

            int n = Integer.parseInt(br.readLine());
            String x = br.readLine();

            if (n > 0) {
                x = x.substring(1, x.length() - 1);
                String[] nums = x.split(",");

                for (String num : nums) {
                    deq.add(Integer.parseInt(num));
                }
            }

            for (String param : cmd) {
                switch (param) {
                    case "R":
                        isRear = !isRear;
                        break;
                    case "D":
                        if (!deq.isEmpty()) {
                            if (!isRear) {
                                deq.pollFirst();
                            } else {
                                deq.pollLast();
                            }
                        } else {
                            isError = true;
                        }
                }

                if (isError) {
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (isError) {
                result.append("error").append('\n');
            } else {
                result.append('[');
                if (!isRear) {
                    while (!deq.isEmpty()) {
                        result.append(deq.pollFirst()).append(',');
                    }
                } else {
                    while (!deq.isEmpty()) {
                        result.append(deq.pollLast()).append(',');
                    }
                }
                if (result.length() > 1) {
                    result.deleteCharAt(result.length() - 1);
                }
                result.append(']').append('\n');
            }
            sb.append(result);

            cmd.clear();
            deq.clear();
            isRear = false;
            isError = false;
        }

        System.out.println(sb.toString());
    }
}
