import java.util.*;
import java.util.stream.*;

public class Programmers73393 {
    // 이분탐색의 타겟이 무엇인가? -> 예산 가격
    // 따라서 예산 가격에 대해 이분탐색을 하도록 만든다.
    // 잘 못 생각했던 것 : 굳이 정해진 예산 배열 사이에서 값을 찾을 필요는 없음

    int solution(int[] budgets, int M) {
        int min = 0;
        int max = Arrays.stream(budgets).max().orElse(-1);

        int answer = 0;
        while (min <= max) {
            final int mid = (min + max) / 2;

            int sum = Arrays.stream(budgets).map(budget -> Math.min(budget, mid)).sum();
            if (sum <= M) {
                min = mid + 1;
                answer = mid;
            } else {
                max = mid - 1;
            }
        }
        return answer;
    }
}
