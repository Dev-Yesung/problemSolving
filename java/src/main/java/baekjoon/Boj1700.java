package baekjoon;

import java.io.*;
import java.util.*;

public class Boj1700 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] param = br.readLine().split(" ");
        int n = Integer.parseInt(param[0]);
        int k = Integer.parseInt(param[1]);

        int[] powers = new int[k];
        param = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            powers[i] = Integer.parseInt(param[i]);
        }

        int cnt = 0, ans = 0;
        boolean[] isUsed = new boolean[101];
        for (int i = 0; i < n; i++) {
            int idx = powers[i];

            if (!isUsed[idx]) {
                if (cnt < n) {
                    isUsed[idx] = true;
                    cnt++;
                    continue;
                }

                List<Integer> laterList = new ArrayList<>();
                for (int j = i; j < k; j++) {
                    if (isUsed[powers[j]] && !laterList.contains(powers[j])) {
                        laterList.add(powers[j]);
                    }
                }

                if (laterList.size() != n) {
                    for (int j = 0; j < isUsed.length; j++) {
                        if (isUsed[j] && !laterList.contains(j)) {
                            isUsed[j] = false;
                            break;
                        }
                    }
                } else {
                    int remove = laterList.get(laterList.size() - 1);
                    isUsed[remove] = false;
                }

                isUsed[idx] = true;
                ans++;
            }
        }

        System.out.println(ans);
    }
}
