package baekjoon;

import java.io.*;

// 1. 아 뭐야 이거 생각해보니까 500 * 500 * 256이면 0부터 타겟으로 설정해서
// 브루트포스 쓰면 그만인거잖아 하...

// 2. 이거 생각해보니까 파라메트릭 서치로 높이 값을 찾아서 풀 수 있는거 아니야?
// 아 근데 시간의 하한이 주어지지 않아서 사용불가하겠다...
// --> 폐기

// 최소 시간이 들 때의 높이 시간과 높이 찾기
public class Boj18111 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]);

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int val = Integer.parseInt(line[j]);
                map[i][j] = val;
            }
        }

        int min = Integer.MAX_VALUE;
        int h = Integer.MAX_VALUE;
        for (int target = 0; target <= 256; target++) {
            int time = getTime(map, target, b);
            if (min > time) {
                min = time;
                h = target;
            } else if (min == time) {
                h = Math.max(h, target);
            }
        }

        System.out.println(min + " " + h);
    }

    static int getTime(int[][] map, int target, int b) {
        int time = 0;
        int needNum = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > target) {
                    int block = map[i][j] - target;
                    time += block * 2;
                    b += block;
                } else if (map[i][j] < target) {
                    int block = target - map[i][j];
                    if (block > b) {
                        needNum += block;
                        continue;
                    }
                    time += block;
                    b -= block;
                }
            }
        }

        if (b >= needNum) {
            time += needNum;
        } else {
            return Integer.MAX_VALUE;
        }
        return time;
    }
}
