package ps;

import java.io.*;
import java.util.*;

public class Boj18808 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] laptop = new int[42][42];
    static int[][] sticker = new int[12][12];
    static int n, m, k;

    public static void main(String[] args) throws IOException {
        String[] params = br.readLine().split(" ");
        n = Integer.parseInt(params[0]);
        m = Integer.parseInt(params[1]);
        k = Integer.parseInt(params[2]);

        // 계산의 편의를 위해 중복이더라도 방향 4가지 모두 갖고있다고 생각하자.
        // 스티커를 k개 붙이는 걸 시도하고 입력으로 주어진 순서대로 붙인다.
        for (int count = 0; count < k; count++) {
            String[] size = br.readLine().split(" ");
            int row = Integer.parseInt(size[0]);
            int col = Integer.parseInt(size[1]);

            for (int r = 0; r < row; r++) {
                String[] pos = br.readLine().split(" ");
                for (int c = 0; c < col; c++) {
                    sticker[r][c] = Integer.parseInt(pos[c]);
                }
            }
        }
    }


    static void rotateSticker() {

    }
}
