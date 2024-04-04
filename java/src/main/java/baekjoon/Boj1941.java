package baekjoon;

import java.io.*;
import java.util.*;

public class Boj1941 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Person[][] map = new Person[5][5];

    public static void main(String[] args) throws IOException {
        for (int row = 0; row < 5; row++) {
            char[] arr = br.readLine().toCharArray();
            for (int col = 0; col < 5; col++) {
                Person p = new Person(row, col, arr[col]);
                map[row][col] = p;
            }
        }




    }

    static class Person {
        int x;
        int y;
        int p;

        public Person(int x, int y, char p) {
            this.x = x;
            this.y = y;
            this.p = p;
        }
    }
}
