package programmers;

import java.util.*;

// 이전에 풀었던 '기지국 설치'와 완전히 동일 : https://school.programmers.co.kr/learn/courses/30/lessons/12979
// 알고리즘 책에 나와있는 고전적인 문제인 '강의실 예약' 문제와도 동일
public class Programmers42884 {
	public int solution(int[][] routes) {
		Arrays.sort(routes, Comparator.comparingInt(route -> route[1]));
		int answer = 0;
		int last = Integer.MIN_VALUE;
		for (int[] route : routes) {
			if (last >= route[0] && last <= route[1]) {
				continue;
			}
			last = route[1];
			answer++;
		}

		return answer;
	}
}
