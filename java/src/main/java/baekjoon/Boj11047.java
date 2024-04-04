package baekjoon;

import java.io.*;
import java.util.*;


/*
    그리디의 정당성 증명은 귀류법을 통해 확인할 수 있다.
    https://blog.encrypted.gg/975 -> 6:25부터 참고
    10/100원 동전을 5개 이상 사용하면 50/500원 동전으로 개수를 줄일 수 있다.
    50원 동전 2개 이상 사용하면 100원 동전으로 개수를 줄일 수 있다.
    이와 같은 논리를 계속 전개하면 된다.
    결국 10/100원 동전은 4개 이하로, 50원 동전은 1개 이하로 사용하는 경우에만
    동전을 최소로 소모하면서 물건값을 지불하는 것이 된다.
 */
public class Boj11047 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        list.sort(Collections.reverseOrder());

        int coin = 0;
        for (int elem : list) {
            if (elem <= k) {
                coin += k / elem;
                k %= elem;
            }
        }

        System.out.println(coin);
    }
}
