package ps;

import java.io.*;
import java.util.*;

public class Boj1316 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean[] isAlready = new boolean[100];
            boolean isGroup = true;

            String s = br.readLine();
            char[] c = s.toCharArray();
            isAlready[c[0] - '0'] = true;
            for (int j = 1; j < s.length(); j++) {
                if (c[j] != c[j - 1] && isAlready[c[j] - '0']) {
                    isGroup = false;
                    break;
                }

                isAlready[c[j] - '0'] = true;
            }

            if (isGroup) {
                count++;
            }
        }

        System.out.println(count);
    }
}
