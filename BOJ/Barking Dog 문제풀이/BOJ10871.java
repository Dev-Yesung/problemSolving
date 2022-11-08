import java.io.*;

public class BOJ10871 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] cmds = br.readLine().split(" ");
		int N = Integer.parseInt(cmds[0]);
		int X = Integer.parseInt(cmds[1]);
		String[] numbers = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			int parse = Integer.parseInt(numbers[i]);
			if (X > parse) {
				bw.write(parse + " ");
			}
		}
		bw.write("\n");
		bw.flush();
		bw.close();
        
	}
}
