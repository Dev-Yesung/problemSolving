package baekjoon;

import java.io.*;
import java.util.*;

public class Boj1919 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] str1 = new int[123];
    static int[] str2 = new int[123];
    static int total;

    public static void main(String[] args) throws IOException {

        String input1 = br.readLine();
        String input2 = br.readLine();
        for (char ch : input1.toCharArray()) {
            str1[ch]++;
        }
        for (char ch : input2.toCharArray()) {
            str2[ch]++;
        }

        for (int i = 97; i <= 122; i++) {
            total += Math.abs(str1[i] - str2[i]);
        }

        System.out.println(total);
    }
}
