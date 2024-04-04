package baekjoon;

import java.io.*;
import java.util.*;

class StudentClass {

    int[] studentNumber = new int[2];

    public void addNumber(int sex) {
        studentNumber[sex]++;
    }

    public int getFemaleNumber() {
        return studentNumber[0];
    }

    public int getMaleNumber() {
        return studentNumber[1];
    }
}

public class Boj13300 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<StudentClass> sc = new ArrayList<>();
    static StringTokenizer st;
    static int roomNumber;

    static int N, K, S, Y;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        st = new StringTokenizer(input, " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        sc.add(0, null);
        for (int i = 1; i <= 6; i++) {
            sc.add(i, new StudentClass());
        }

        for (int i = 0; i < N; ++i) {
            input = br.readLine();
            st = new StringTokenizer(input, " ");
            S = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            StudentClass student = sc.get(Y);
            student.addNumber(S);
        }

        for (StudentClass s : sc) {
            if (s == null) {
                continue;
            }

            if (s.getFemaleNumber() % K == 0) {
                roomNumber += s.getFemaleNumber() / K;
            } else {
                roomNumber += (s.getFemaleNumber() / K) + 1;
            }

            if (s.getMaleNumber() % K == 0) {
                roomNumber += s.getMaleNumber() / K;
            } else {
                roomNumber += (s.getMaleNumber() / K) + 1;
            }
        }

        System.out.println(roomNumber);
    }
}
