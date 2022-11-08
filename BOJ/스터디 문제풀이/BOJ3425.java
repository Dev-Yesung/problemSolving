import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class BOJ3425 {
    public static ArrayList<String[]> list = new ArrayList<>();
    public static Stack<long[]> stack = new Stack<>();
    public static String inputLine;
    public static String[] cmdArgs;
    public static long initNum;
    public static boolean noError = false;
    public static final long ERROR = 1000000000;

    public static boolean solution() {
        long num;
        int negative = 0;

        stack.push(new long[] {initNum});
        for(String[] elem : list) {
            if (elem[0].equals("NUM")) {
                stack.push(new long[]{Long.parseLong(elem[1])});
            } else if (elem[0].equals("POP")) {
                if (stack.empty()) return false;
                stack.pop();
            } else if(elem[0].equals("INV")) {
                if(stack.empty()) return false;
                num = stack.pop()[0];
                stack.push(new long[]{-num});
            } else if(elem[0].equals("DUP")) {
                if(stack.empty()) return false;
                num = stack.peek()[0];
                stack.push(new long[]{num});
            } else if(elem[0].equals("SWP")) {
                if(stack.size() < 2) return false;
                long num1 = stack.pop()[0];
                long num2 = stack.pop()[0];
                stack.push(new long[]{num1});
                stack.push(new long[]{num2});
            } else if (elem[0].equals("ADD")) {
                if(stack.size() < 2) return false;
                long num1 = stack.pop()[0];
                long num2 = stack.pop()[0];
                stack.push(new long[]{num1 + num2});
            } else if (elem[0].equals("SUB")) {
                if(stack.size() < 2) return false;
                long num1 = stack.pop()[0];
                long num2 = stack.pop()[0];
                stack.push(new long[]{num2 - num1});
            } else if (elem[0].equals("MUL")) {
                if(stack.size() < 2) return false;
                long num1 = stack.pop()[0];
                long num2 = stack.pop()[0];
                stack.push(new long[]{num2 * num1});
            } else if (elem[0].equals("DIV")) {
                if(stack.size() < 2) return false;

                long num1 = stack.pop()[0];
                long num2 = stack.pop()[0];
                if(num1 == 0) return false;

                if(num1 < 0) {
                    num1 = -num1;
                    negative++;
                }
                if(num2 < 0) {
                    num2 = -num2;
                    negative++;
                }

                if(negative == 1) stack.push(new long[]{-(num2/num1)});
                else stack.push(new long[]{num2/num1});
            } else if (elem[0].equals("MOD")) {
                if(stack.size() < 2) return false;

                long num1 = stack.pop()[0];
                long num2 = stack.pop()[0];
                if(num1 == 0) return false;

                if(num2 < 0) stack.push(new long[]{-((-num2)%num1)});
                else stack.push(new long[]{(num2%num1)});
            }
        }
        return true;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            while(true) {
                inputLine = br.readLine();
                if(inputLine.equals("")) continue;
                cmdArgs = inputLine.split(" ");

                if(cmdArgs[0].equals("QUIT")) break;

                if(cmdArgs[0].equals("NUM")) {
                    list.add(new String[] {cmdArgs[0], cmdArgs[1]});
                } else if(cmdArgs[0].equals("END")) {
                    break;
                } else {
                    list.add(new String[] {cmdArgs[0]});
                }
            }
            if(cmdArgs[0].equals("QUIT"))  break;

            int testCase= Integer.parseInt(br.readLine());
            for(int i = 0; i < testCase; i++) {
                initNum = Long.parseLong(br.readLine());
                noError = solution();

                if (!noError && stack.size() != 1) {
                    sb.append("ERROR");
                } else {
                    if(Math.abs(stack.peek()[0]) > ERROR)
                        sb.append("ERROR");
                    else
                        sb.append(stack.peek()[0]);
                }
                sb.append("\n");

                while (!stack.empty()) stack.pop();
            }
            sb.append("\n");
            while(!list.isEmpty()) list.remove(0);
        }
        System.out.printf("%s", sb.toString());
    }
}
