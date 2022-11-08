import java.io.*;

public class BOJ10808 {
    static int[] alphabet = new int[75];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main (String[] args)throws IOException {
        String word = br.readLine();
        for(char c : word.toCharArray()) {
            int idx = c - '0';
            alphabet[c-'0']++;
        }

        for(int i = 49; i < 75; i++) {
            bw.write(alphabet[i] +" ");
        }
        bw.flush();
        bw.close();
    }
}
