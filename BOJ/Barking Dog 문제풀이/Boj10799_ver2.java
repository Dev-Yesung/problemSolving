package ps;

import java.io.*;

public class Boj10799_ver2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char before;
    static int open;
    static int ans;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        for (char ch : input.toCharArray()) {
            switch (ch) {
                case '(':
                    open++;
                    before = ch;
                    break;
                case ')':
                    open--;
                    if (before == '(') {
                        ans += open;
                    } else {
                        ans += 1;
                    }
                    before = ch;
            }
        }
        System.out.println(ans);
    }
}
