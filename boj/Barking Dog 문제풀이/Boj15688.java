package ps;

import java.io.*;
import java.util.*;


// Scanner는 시간복잡도뿐만 아니라 공간복잡도(메모리)도 많이 잡아먹는다.
// 만일 모든 요구사항을 다 맞췄는데 시간초과, 메모리초과가 발생한다면 Scanner를 의심해보자.
public class Boj15688 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] nums = new int[2_000_001];

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(br.readLine());
            nums[1_000_000 + num]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2_000_001; i++) {
            while (nums[i] > 0) {
                sb.append(i - 1_000_000).append('\n');
                nums[i]--;
            }
        }
        System.out.print(sb);
    }
}
