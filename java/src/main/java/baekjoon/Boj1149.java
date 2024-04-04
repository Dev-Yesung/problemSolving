package baekjoon;

import java.io.*;
import java.util.*;

// 백트래킹 방식으로도 가능하지 않을까??
// 나중에 풀어보기
// 그리디하게 풀면 망하는 대표적인 문제
public class Boj1149 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);

            PriorityQueue<Integer> pqAsc = new PriorityQueue<>(list);
            PriorityQueue<Integer> pqDesc = new PriorityQueue<>(list);
            pqAsc.add(num);
            pqDesc.add(num);

//            if (pqAsc.size() % 2 == 0) {
//                while
//            } else {
//
//            }
        }

    }

}
