import java.util.LinkedList;
import java.util.Queue;

// 참고링크 : https://rookie-developer.tistory.com/m/338
// 코딩테스트에 자주 나오는 알고리즘 기본 코드 구조 정리
// 일단 외워 놓으면 반은 먹고 들어간다...!
public class CodeSnippet {

	private static final int N = 10;
	private static final int M = 8;
	private static final int R = 3;

	public static void main(String[] args) {

	}

	// 기본적으로 반복되는 재귀 구조
	int factorial(int n) {
		// 종료 조건
		if (n <= 1) {
			return 1;
		}

		// 단위 반복
		return n + factorial(n - 1);
	}

	// 2차원 배열
	void twoDimensionalArray(int n, int m) {
		int[][] arr = new int[n][m];
		// 행 우선 순회
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		// 열 우선 순회
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		// 지그재그 순회
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				/*
					[j + ((m - 1) - (2 * j)) * (i % 2)]로 계산을 해야하는 이유
					> i 가 짝수일 때는 j가 0부터 m - 1 까지 돌아야 한다.
					> i 가 홀수일 때는 m - 1 - j가 m - 1부터 0 까지 돌아야 한다.
					> j 값이 i 값이 0이든 1이든 상관 없이 돌게 만들어야 하므로 이런 식을 사용해야 한다.
				 */
				System.out.print(arr[i][j + ((m - 1) - (2 * j)) * (i % 2)] + " ");
			}
			System.out.println();
		}
	}

	// 일반 순열
	// 0부터 N 까지 수 중에 count 개수만큼 선택하여 만드는 순열
	private static final int[] picked = new int[R];
	private static final boolean[] selected = new boolean[N];

	void permutation1(int count) {
		if (count == R) {
			// count 만큼의 수를 모두 선택함
			return;
		}

		for (int i = 0; i < N; i++) {
			if (selected[i]) {
				// 이미 선택한 숫자이므로 스킵
				continue;
			}
			// count 번째 수를 i로 선택
			picked[count] = i;
			// 숫자 i를 선택했기 때문에 true 로 표시 -> 다음에 수를 뽑을 때 선택하지 않음
			selected[i] = true;
			// 재귀적으로 다음 숫자 선택
			permutation1(count + 1);
			// 다음 경우의 수를 체크하기 위해 선택했던 수를 false 처리
			selected[i] = false;
		}
	}

	// 중복 순열
	void permutation2(int count) {
		if (count == R) {
			// count 만큼의 수를 모두 선택함
			return;
		}
		for (int i = 0; i < N; i++) {
			// count 번째 수를 i로 선택
			picked[count] = i;
			// 중복 순열이기 때문에 i번째 수를 또 선택해도 상관 없다.
			// 재귀적으로 다음 숫자 선택
			permutation2(count + 1);
		}
	}

	// 조합
	// start 부터 N 까지의 수 조합을 만드는 것
	// 루프를 start 부터 시작해서 다음 재귀에 i + 1해야 하는 이유는
	// 이미 선택한 수를 다시 선택하면 안되고 다음 숫자를 선택해야하고
	// 조합이므로 숫자 순서에 상관없이 같은 구성이 하나만 있어야 하기 때문이다.
	void combination1(int count, int start) {
		if (count == R) {
			// 종료
			return;
		}

		for (int i = start; i < N; i++) {
			picked[count] = i;
			combination1(count + 1, i + 1);
		}
	}

	// 중복조합
	void combination2(int count, int start) {
		if (count == R) {
			// 종료
			return;
		}

		for (int i = start; i < N; i++) {
			picked[count] = i;
			// 중복조합은 숫자가 중복되어도 상관 없음!
			combination1(count + 1, i);
		}
	}

	// 부분집합
	void subset(int count) {
		if (count == N) {
			// 부분 집합의 개수를 셀거면 여기에 카운트 변수를 넣으면 된다.
			return;
		}

		/*
			예를 들어 다음과 같이 count == 0, N == 10 이라고 해보자.
			처음에는 [0, 1, 2, 3 ... 9] 까지 selected 에 true 로 체크된다.
			재귀가 풀리면서 (백트래킹)에 의해 부분집합을 찾는 알고리즘이다.
			[0, 1, 2, 3 ... 8], [0, 1, 2, 3 ... 8, 9]
			[0, 1, 2, 3 ... 7], [0, 1, 2, 3 ... 7, 8], [0, 1, 2, 3 ... 7, 9]
			...
			이런 식으로 부분 집합이 체크 된다.
		 */
		selected[count] = true;
		subset(count + 1);
		selected[count] = false;
		subset(count + 1);
	}

	// 완전탐색 (BFS, DFS)
	private static final int[][] map = new int[N][M];
	private static final boolean[][] visited = new boolean[N][M];
	// 왼쪽, 위, 오른쪽, 아래
	private static final int[] dx = {0, -1, 0, 1};
	private static final int[] dy = {-1, 0, 1, 0};
	private static final Queue<int[]> queue = new LinkedList<>();

	// BFS(너비우선탐색)
	void bfs(int r, int c) {
		// r, c는 시작위치
		// 방문처리하고 큐에 위치 넣기
		visited[r][c] = true;
		queue.offer(new int[] {r, c});

		// bfs 시작
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				// 다음 위치 지정
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				// 다음 이동할 위치가 유효한지 체크
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					// 배열을 벗어나면 스킵
					continue;
				}
				if (visited[nx][ny]) {
					// 이미 방문한 위치라면 스킵
					continue;
				}
				// 방문처리하고 큐에 위치 넣기
				visited[nx][ny] = true;
				queue.offer(new int[] {nx, ny});
			}
		}
	}

	// DFS(깊이우선탐색) -> 재귀를 활용 -> 함수가 메모리에 스택으로 쌓이기 때문에 가능
	void dfs(int r, int c) {
		if (r == N - 1 && c == M - 1) {
			return;
		}

		for (int i = 0; i < 4; i++) {
			// 다음 위치 지정
			int nx = r + dx[i];
			int ny = c + dy[i];

			// 다음 이동할 위치가 유효한지 체크
			if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
				// 배열을 벗어나면 스킵
				continue;
			}
			if (visited[nx][ny]) {
				// 이미 방문한 위치라면 스킵
				continue;
			}

			// 큐에 위치를 넣고 다음위치 방문
			visited[nx][ny] = true;
			dfs(nx, ny);
		}
	}

	// 이진트리 완전탐색(BFS, DFS)l
	private static final int lastIndex = 15; // 트리에 숫자가 마지막으로 들어간 칸의 index
	private static final int[] nodes = new int[N];
	private static final Queue<Integer> treeQueue = new LinkedList<>();

	// BFS(너비우선탐색)
	// 이진 트리의 루트부터 내려가면서 BFS 로 탐색
	void bfsBinTree() {
		treeQueue.offer(1);
		while (!treeQueue.isEmpty()) {
			// 이진트리에서 현재 위치
			int cur = treeQueue.poll();

			// 이진트리의 왼쪽 자식 위치를 넣음
			if (2 * cur <= lastIndex) {
				treeQueue.offer(2 * cur);
			}
			// 이진트리의 오른쪽 자식 위치를 넣음
			if (2 * cur + 1 <= lastIndex) {
				treeQueue.offer(2 * cur + 1);
			}
		}
	}

	// BFS(너비우선탐색)
	// 이진 트리의 루트부터 내려가면서 BFS 로 탐색
	private static final boolean[] vis = new boolean[N];

	void dfsBinTree(int cur) {
		// 이미 방문한 위치면 바로 리턴
		if (vis[cur]) {
			return;
		}

		// 현재 위치 방문처리
		vis[cur] = true;
		if (2 * cur <= lastIndex) {
			// 왼쪽 자식 방문
			dfsBinTree(2 * cur);
		}
		if (2 * cur + 1 <= lastIndex) {
			// 오른쪽 자식 방문
			dfsBinTree(2 * cur + 1);
		}
	}

	// 이진 트리 순회(전위, 중위, 후위) by DFS
	// 전위 순회
	void dfsByPreOrder(int cur) {
		if (cur > lastIndex) {
			return;
		}

		// 로직 수행
		System.out.print(nodes[cur] + " ");
		// 왼쪽 자식 방문
		dfsByPreOrder(2 * cur);
		// 오른쪽 자식 방문
		dfsByPreOrder(2 * cur + 1);
	}

	// 중위 순회
	void dfsByInOrder(int cur) {
		if (cur > lastIndex) {
			return;
		}

		// 왼쪽 자식 방문
		dfsByInOrder(2 * cur);
		// 로직 수행
		System.out.print(nodes[cur] + " ");
		// 오른쪽 자식 방문
		dfsByInOrder(2 * cur + 1);
	}

	// 후위 순회
	void dfsByPostOrder(int cur) {
		if (cur > lastIndex) {
			return;
		}

		// 왼쪽 자식 방문
		dfsByPostOrder(2 * cur);
		// 오른쪽 자식 방문
		dfsByPostOrder(2 * cur + 1);
		// 로직 수행
		System.out.print(nodes[cur] + " ");
	}

	/*
		분할 정복
		1) 분할 : 해결할 문제를 여러 개의 작은 부분으로 나눈다.
		2) 정복 : 나눈 작은 문제를 각각 해결한다.
		3) 통합 : 해결된 해답을 모은다.
	 */
	// r : 행, c: 열, w: 분할에 필요한 길이
	void divideAndConquer(int r, int c, int w) {

		// 이 부분에 로직 수행(정복)
		// 이 부분에서 해야할 만큼만 일을 한다.

		// 사분할 해서 재귀
		// 분할 진입 조건
		if (w > 1) {
			divideAndConquer(r, c, w / 2); // w를 반으로 줄임
			divideAndConquer(r, c + w / 2, w / 2); // c를 w/2만큼 늘림
			divideAndConquer(r + w / 2, c, w / 2); // r을 w/2만큼 늘림
			divideAndConquer(r + w / 2, c + w / 2, w / 2); // r과 c를 w/2만큼 늘림
		}
	}

	// 분할정복 -> 반복문으로 이진검색
	// numbers 는 오름차순으로 정렬된 수들, n은 수의 개수, key는 찾는 값
	int binarySearchByLoop(int[] numbers, int N, int key) {
		int start = 0;
		int end = N - 1;

		// start와 end가 같은 경우도 반드시 넣어야
		// 그 경우에 답을 찾을 수 있음
		while (start <= end) {
			int mid = (start + end) / 2;
			if (numbers[mid] == key) {
				// 탐색에 성공한 경우, numbers의 인덱스를 반환
				return mid;
			} else if (numbers[mid] < key) {
				// 찾는 값이 numbers[mid]보다 큰 경우 start를 조정
				start = mid + 1;
			} else if (numbers[mid] > key) {
				// 찾는 값이 numbers[mid]보다 작은 경우 end를 조정
				end = mid - 1;
			}
		}

		// 탐색에 실패한 경우
		return -1;
	}

	// 분할정복 -> 재귀로 이진검색
	int binarySearchByRecursion(int[] numbers, int start, int end, int key) {
		if (start > end) {
			// 재귀로 계속 파고들다보면 end보다 start가 작아지는 지점이 있음
			// 이 경우 찾고자 하는 값을 못찾은 경우이다.
			return -1;
		}

		int mid = (start + end) / 2;
		if (numbers[mid] == key) {
			// 답을 찾은 경우 위치를 반환
			return mid;
		} else if (numbers[mid] < key) {
			return binarySearchByRecursion(numbers, mid + 1, end, key);
		} else if (numbers[mid] > key) {
			return binarySearchByRecursion(numbers, start, mid - 1, key);
		}

		return -1;
	}

	// 그래프 버전의 DFS와 BFS

	// 1. 인접행렬 버전 BFS
	private static final int[][] matrix = new int[N][N];

	void adjMatrixBfs(int startVertex) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N];

		// 방문처리 후 시작 vertex 를 큐에 추가
		visited[startVertex] = true;
		queue.add(startVertex);

		// BFS 시작
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < N; i++) {
				if (visited[cur] || matrix[cur][i] == 0) {
					// 이미 방문했거나 도달 할 수 없는 위치인 경우
					continue;
				}
				visited[i] = true;
				queue.offer(i);
			}
		}
	}

	// 2. 인접 리스트 버전 BFS
	private static final Vertex[] vertices = new Vertex[N];

	void adjListBfs(int startVertex) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N];

		// 방문처리 후 큐에 넣음
		visited[startVertex] = true;
		queue.add(startVertex);
		// BFS 시작
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (Vertex node = vertices[cur]; node != null; node = node.next) {
				visited[node.value] = true;
				queue.offer(node.value);
			}
		}
	}

	// 인접행렬 버전 DFS
	private static final boolean[] adjVisited = new boolean[N];
	private static final int[][] adjMatrix = new int[N][N];

	void adjMatrixDfs(int cur) {
		// 정점 방문처리
		adjVisited[cur] = true;
		// DFS 시작
		for (int i = 0; i < N; i++) {
			if (adjVisited[i] || adjMatrix[cur][i] == 0) {
				// 이미 방문했거나 갈 수 없는 위치인 경우
				continue;
			}
			adjMatrixDfs(i);
		}
	}

	// 인접 리스트 버전 DFS
	void adjListDfs(int cur) {
		adjVisited[cur] = true;
		for (Vertex node = vertices[cur]; node != null; node = node.next) {
			if (adjVisited[node.value]) {
				continue;
			}
			adjListDfs(node.value);
		}
	}



	static class Vertex {

		public int value;
		public Vertex next;

		public Vertex(int value, Vertex next) {
			this.value = value;
			this.next = next;
		}
	}

}
