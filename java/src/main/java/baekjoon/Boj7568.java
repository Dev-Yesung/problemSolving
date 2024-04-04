package baekjoon;

import java.io.*;

class Boj7568 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] height = new int[50];
    static int[] weight = new int[50];
    static int[] counter = new int[50];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] param = br.readLine().split(" ");
            height[i] = Integer.parseInt(param[0]);
            weight[i] = Integer.parseInt(param[1]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 본인보다 체급이 낮은 사람의 수를 저장한다.
                if ((height[i] < height[j]) && (weight[i] < weight[j])) {
                    counter[i]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(counter[i] + 1).append(' ');
        }

        System.out.println(sb);
    }
}
