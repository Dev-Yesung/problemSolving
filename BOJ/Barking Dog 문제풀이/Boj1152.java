package ps;

import java.io.*;
import java.util.*;

public class Boj1152 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String line = br.readLine();
        line = line.trim();

        StringTokenizer st = new StringTokenizer(line, " ");
        System.out.println(st.countTokens());
    }
}
