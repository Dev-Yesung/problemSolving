package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/49191
/*
	[ 그래프가 필요한 순간? ]
	너무 당연한 말이지만, 데이터 사이의 연결된 관계를 가지고 문제를 해결해야 할 때 사용한다.

	다른 자료구조와 그래프의 다른 점을 생각해보자.

	List는 관계 설정보다는 공통점이 있는 데이터들을 모아두는 방식이다.
	Map은 어떤가? 특정 데이터 / 조합된 결과를 빠르게 찾아야 할 경우 사용한다.
	Set은 어떤가? 데이터들의 집합은 맞지만 중복없는 모음을 만들고 싶을 때 사용한다.

	Tree도 물론 관계 설정에 사용할 수 있다.
	하지만 루트 노드 혹은 특정 노드로부터 시작해 트리 레벨에 따라 접근을 한다는 점에서
	양방향 관계 보다는 단방향, 하향식 관계를 설정하는데 좀 더 적합하다는 생각이든다.
	또 트리와 함께 사용되는 데이터들은 특성에 따라 적절히 정렬하여 사용하는 경우가 많다.
	Tree도 엄밀히 말하면 특수한 그래프지만, 일단 문제풀이를 할 때는 일반적인 그래프와 구분하자.

	[ 문제 핵심 아이디어 ]
	누가 몇 등인지는 중요하지 않다. 중요한 것은 그 사람의 순위가 정확하게 정해질 수 있는지 여부다.
	그렇다면 순위가 정확하게 정해지는 경우는 언제일까? '승리횟수(이긴 사람 수) + 패배횟수(진 사람 수) + 1(본인) == 총 인원'일 때이다.

	1) 한 명의 사람이 모든 사람들과 경기한 결과가 있을 경우  정확하게 순위가 결정된다.
	2) 사람들의 시합 결과를 가지고 상대적으로 정해질 수 있다.
	> 두 번째 케이스로 순위를 결정 할 수 있는 이유는 문제설명에 '만약 A 선수가 B 선수보다 실력이 좋다면 A 선수는 B 선수를 항상 이깁니다.'란 조건 때문이다.
	> 만일 선수1이 선수2를 이기고 선수2가 선수3을 이겼다고 해보자.
	> 여기서 선수1은 무조건 선수3을 이기게 된다. 왜냐하면 선수1은 선수2보다 실력이 좋고 선수2는 선수3 보다 실력이 좋다.
	> 따라서 선수1은 선수3보다 실력이 좋고 둘의 시합 결과가 나와있지 않아도 선수1이 선수3을 이긴다는 걸 알 수 있다.

	따라서 문제를 풀 때 필요한 것은 아래와 같다.
	1) 시합에 참여하는 사람들 사이에 승리 혹은 패배에 관한 관계를 설정한다. -> 이때 그래프를 사용할 수 있다.
	2) 설정된 관계(자료구조, 그래프)를 가지고 승리 횟수, 패배 횟수를 세어보자.
	3) 승리 횟수 + 패배 횟수 + 1이 n과 동일한 경우 answer에 1을 더한다.
	4) 노드마다 1~3 반복

 */
public class Programmers49191_1 {

	public static void main(String[] args) {
		int answer = new Programmers49191_1()
			.solution(5, new int[][] {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});

		System.out.println(answer);
	}

	public int solution(int n, int[][] results) {
		boolean[][] graph = new boolean[n][n];
		for (int[] edge : results) {
			int winner = edge[0] - 1;
			int loser = edge[1] - 1;
			graph[winner][loser] = true;
		}

		int answer = 0;
		for (int v = 0; v < n; v++) {
			int wins = countForward(v, graph, new boolean[n]) - 1;
			int loses = countBackward(v, graph, new boolean[n]) - 1;

			if (wins + loses + 1 == n) {
				answer++;
			}

		}

		return answer;
	}

	private int countForward(int targetVertex, boolean[][] graph, boolean[] isVisited) {
		int count = 1;

		for (int vertex = 0; vertex < graph.length; vertex++) {
			if (!graph[targetVertex][vertex] || isVisited[vertex]) {
				continue;
			}

			isVisited[vertex] = true;
			count += countForward(vertex, graph, isVisited);
		}

		return count;
	}

	private int countBackward(int targetVertex, boolean[][] graph, boolean[] isVisited) {
		int count = 1;

		for (int vertex = 0; vertex < graph.length; vertex++) {
			if (!graph[vertex][targetVertex] || isVisited[vertex]) {
				continue;
			}

			isVisited[vertex] = true;
			count += countBackward(vertex, graph, isVisited);
		}

		return count;
	}
}
