package ps;

import java.io.*;
import java.util.*;

public class Boj2941 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        List<String> list = List.of("dz=", "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=");

        String input = br.readLine();
        for (String s : list) {
            while (input.contains(s)) {
                input = input.replaceFirst(s, " ");
            }
        }

        System.out.println(input.length());
    }
}
