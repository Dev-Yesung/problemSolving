import java.util.*;
import java.util.stream.*;

public class Programmers42746 {

    /*
        처음에는 높은 자리 수부터 낮은 자리로 이동하면서 정렬을 진행해야겠다고 생각했다.
        하지만 10과 1중에 우선순위가 1이 더 높다.
        이 부분을 처리해야할 알고리즘을 생각했더니
        결국 자릿수가 많아질수록 구현 난이도가 증가했다.
        그래서 아이디어를 폐기했다.
        또한 이 문제를 숫자로 생각해서 풀게되면 구성된 숫자가 클 때
        integer 범위를 넘어가게 된다. 따라서 숫자로 푸는 것에는 무리가 있다.
        반환하는 타입이 문자열 타입이기 때문에 문자열로 다루는 것이 바람직하다.

        가장 큰 수를 보면 숫자로써 가장 큰 수가 앞에 오는 것이 아닌
        문자로써 가장 큰수(자릿수)가 앞에 온다.

        따라서 숫자 -> 문자 -> 내림차순 정렬 -> 조합 으로 처리하면 가장 큰수가 나온다.

        tip 정확성 테스트에서 시간초과가 나는 경우
        1. 루프에서 무한루프를 도는 경우
        2. 제한된 최대 시간보다 넘는 느린 연산 -> 효율성 부족
     */
    public String solution(int[] numbers) {
        // 숫자 -> 문자
        // String[] strNums = IntStream.of(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        // of 메서드는 내부적으로 Arrays.stream(numbers)로 바뀌므로 아래의 방법과 동일하다!
//        String[] strNums = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
//
//        // 내림차순 정렬할 때 기준을 s1 + s2와 s2 + s1을 비교해서 더 큰 수가 앞에 오도록 정렬
//        Arrays.sort(strNums, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        // 문자열 변환부터 comparator 에 따른 내림차순 정렬까지 한 큐에 정리가능!
//        String[] strNums = Arrays.stream(numbers)
//                                 .mapToObj(String::valueOf)
//                                 .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
//                                 .toArray(String[]::new);
//
//        if (strNums[0].equals("0")) {
//            return "0";
//        }
//        return Arrays.stream(strNums).reduce("", (s1, s2) -> s1 + s2);

        // 아예 아래와 같이 극단적으로 간단하게 바꿀 수도 있음
        String answer = IntStream.of(numbers)
                                 .mapToObj(String::valueOf)
                                 .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
                                 .collect(Collectors.joining());
        return answer.startsWith("0") ? "0" : answer;
    }
}
