package ps;

import java.util.*;

public class Boj17478_ver2 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int n;

    public static void main(String[] args) {
        n = sc.nextInt();

        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        solution(0);
        System.out.println(sb);
    }

    static void solution(int count) {
        msgMaker("\"재귀함수가 뭔가요?\"\n", count);
        if (count == n) {
            msgMaker("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n", count);
        } else {
            msgMaker("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n", count);
            msgMaker("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n", count);
            msgMaker("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n", count);
            solution(count + 1);
        }
        msgMaker("라고 답변하였지.\n", count);
    }

    static void msgMaker(final String msg, int depth) {
        for (int i = 0; i < depth; i++) {
            sb.append("____");
        }
        sb.append(msg);
    }
}
