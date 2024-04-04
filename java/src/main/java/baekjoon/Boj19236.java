package baekjoon;

import java.io.*;

public class Boj19236 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Fish[][] map = new Fish[4][4];
    static int SHARK = Integer.MAX_VALUE;
    static int[] xPos = new int[17];
    static int[] yPos = new int[17];
    static int[] dx = {-100, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {-100, 0, -1, -1, -1, 0, 1, 1, 1};
    static int total = 0;

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 4; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 8; j += 2) {
                int num = Integer.parseInt(line[j]);
                int d = Integer.parseInt(line[j + 1]);

                map[i][j / 2] = new Fish(num, d);
                xPos[num] = i;
                yPos[num] = j / 2;
            }
        }

        // (0, 0)으로 상어가 들어감
        total = map[0][0].num;
        int curPos = map[0][0].dir;
        map[0][0] = new Fish(SHARK, curPos);
        // 상어가 들어간 직후 물고기 위치 바꾸기
        rotate();

        // 상어가 물고기 먹음
        // 백트레킹


    }

    static void rotate() {
        for (int i = 1; i < 17; i++) {
            int curX = xPos[i];
            int curY = yPos[i];
            int curDir = map[curX][curY].dir;

            for (int count = 0; count < 8; count++) {
                int dir = (curDir + count) % 8;
                int nx = dx[dir];
                int ny = dy[dir];

                if (nx < 0 || nx > 3 || ny < 0 || ny > 3) {
                    continue;
                }
                if (map[nx][ny].num == SHARK) {
                    continue;
                }

                Fish fish = map[curX][curY];
                map[curX][curY] = map[nx][ny];
                map[nx][ny] = fish;
                break;
            }
        }
    }

    static class Fish {
        int num;
        int dir;

        public Fish(int num, int dir) {
            this.num = num;
            this.dir = dir;
        }
    }
}
