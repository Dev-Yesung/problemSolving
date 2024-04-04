package baekjoon;

import java.io.*;
import java.util.*;

public class Boj2446 {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                sb.append(' ');
            }
            for (int j = 0; j < (2 * n - 1) - (2 * i); j++) {
                sb.append('*');
            }
            sb.append('\n');
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                sb.append(' ');
            }
            for (int j = 0; j < (2 * n - 1) - (2 * i); j++) {
                sb.append('*');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
