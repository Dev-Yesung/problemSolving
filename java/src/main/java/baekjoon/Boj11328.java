package baekjoon;

import java.io.*;
import java.util.*;

public class Boj11328 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int tc;
    static String bf, af;
    static int[] beforeAbc = new int[123];
    static int[] afterAbc = new int[123];

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            String input = br.readLine();
            st = new StringTokenizer(input, " ");
            bf = st.nextToken();
            af = st.nextToken();

            if (bf.length() != af.length()) {
                System.out.println("Impossible");
                continue;
            }

            for (char ch : bf.toCharArray()) {
                beforeAbc[ch]++;
            }

            for (char ch : af.toCharArray()) {
                afterAbc[ch]++;
            }

            int j;
            for (j = 97; j < 123; j++) {
                if (beforeAbc[j] != afterAbc[j]) {
                    System.out.println("Impossible");
                    break;
                }
            }

            if (j == 123) {
                System.out.println("Possible");
            }

            Arrays.fill(beforeAbc, 0);
            Arrays.fill(afterAbc, 0);
        }
    }
}
