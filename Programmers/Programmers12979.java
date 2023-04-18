// 기지국 설치

/*
    이 문제가 그리디한 이유?
    기지국의 설치에 의해 범위가 커버되는데,
    그게 어떤 아파트 옥상에 설치되던 최소로 설치해야하는 개수는 변함없음
    즉 위치가 중요한게 아니고 몇 개를 설치해서 커버가 되는지가 중요
    어디에 설치하던 일단 조건이 되는대로 선택해서 설치하면 되므로 그리디!
 */

import java.util.ArrayList;
import java.util.List;

/*
    효율성을 높이는 팁
    1. loop 를 개선한다
    2. 적절한 자료구조를 사용한다.
    3. 불필요한 오브젝트를 제거한다.
*/
class Programmers12979 {

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        // 기존의 설치된 전파의 위치를 순서대로 하나씩 꺼내서 사용할 것이므로
        // 큐를 사용하여 저장된 위치를 불러온다.
//        Queue<Integer> sq = new LinkedList<>();
//        Arrays.stream(stations).forEach(sq::add);
        // 하지만 이렇게 하면 시간초과가 난다
        // 자바에서 primitive 타입이 object 타입보다 시간을 덜 잡아먹는다.
        // 기본적으로 시간초과가 나면 for loop 를 의심해야하지만
        // for 문은 최적화할 수 있는 부분이 모두 최적화 되어 있다.
        // 따라서 위의 부분을 최적화 시켜야 한다.

        // 큐를 사용하지 말고 배열을 사용하자!
        int sIdx = 0;
        // 포지션이 이동하면서 동 전체를 바라본다.
        int pos = 1;
        while (pos <= n) {
            if (sIdx < stations.length && stations[sIdx] - w <= pos) {
                // 기존의 기지국 범위 내에 들어있으면 기지국을 세울 필요없이
                // 기지국 범위 밖으로 이동시켜 기지국을 짓게 한다.
                pos = stations[sIdx] + w + 1;
                sIdx++;
            } else {
                // 이 변수가 증가한 것은 기지국 설치가 됐다는 것
                answer++;
                // 기지국을 설치하면 오른쪽 기지국 범위만큼 이동하고
                // 그 다음에 왼쪽 기지국 범위만큼 이동해야 최적의 설치 위치가 나옴
                // 이것이 전체 전파범위가 된다.
                pos += 2 * w + 1;
            }
        }

        return answer;
    }
}
