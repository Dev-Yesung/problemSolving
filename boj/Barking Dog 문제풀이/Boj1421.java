package ps;

import java.io.*;

class Boj1421 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] param = br.readLine().split(" ");
        int n = Integer.parseInt(param[0]);
        int c = Integer.parseInt(param[1]);
        int w = Integer.parseInt(param[2]);

        int max = Integer.MIN_VALUE;
        int[] rods = new int[n];
        for (int i = 0; i < n; i++) {
            int rod = Integer.parseInt(br.readLine());
            rods[i] = rod;
            max = Math.max(max, rod);
        }

        long benefit = 0;
        for (int cut = 1; cut <= max; cut++) {
            long val = calcBenefit(rods, cut, c, w);
            benefit = Math.max(benefit, val);
        }

        System.out.println(benefit);
    }

    static long calcBenefit(int[] rods, int cut, int c, int w) {
        // 나무 하나당 길이 = cut
        long val = 0;

        for (int len : rods) {
            int piece = len / cut;
            int cutNum;
            if (len % cut == 0) {
                cutNum = piece - 1;
            } else {
                cutNum = piece;
            }

            int unit = (piece * cut * w) - (cutNum * c);
            if (unit > 0) {
                val += unit;
            }
        }

        return val;
    }
}
