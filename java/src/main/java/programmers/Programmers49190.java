package programmers;

import java.util.*;

/*
	매우 어려웠음. 처음에는 fluid fill 문제처럼 느껴져서 안어려울 줄 알았는데, 아니었음
	인접 리스트로 풀어야 하는 건 이해했는데, 문제는 면이 만들어지는 것을 어떻게 판별할지였음
	1. 새로운 인접리스트에서 기존의 점으로 돌아와야 면이 만들어지는 것이 첫 번째 핵심
	2. 이 과정에서 기존의 엣지가 아니라 새로운 엣지라는 걸 판별할 수 있는지 생각하는 게 두 번째 핵심
	3. 대각선으로 만들어지는 면은 어떻게 판별해야 할지 생각하는게 세 번째 핵심
	(이건 모범 답의 방법 말고 다른 방법으로도 할 수 있을거 같음)
 */

public class Programmers49190 {

	private static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	private static final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

	public int solution(int[] arrows) {
		int answer = 0;
		Map<String, Vertex> vertices = new HashMap<>();
		Vertex v = new Vertex(0, 0);
		vertices.put(v.id, v);

		for (int dir : arrows) {
			for (int i = 0; i < 2; i++) {
				int nx = v.x + dx[dir];
				int ny = v.y + dy[dir];
				String id = Vertex.id(nx, ny);

				if (!vertices.containsKey(id)) {
					vertices.put(id, new Vertex(nx, ny));
				} else if (!v.connectedVertices.contains(id)) {
					answer++;
				}

				Vertex u = vertices.get(id);
				v.connectedVertices.add(u.id);
				u.connectedVertices.add(v.id);
				v = vertices.get(id);
			}
		}

		return answer;
	}

	private static class Vertex {
		public final int x;
		public final int y;
		public final String id;
		public final Set<String> connectedVertices;

		public Vertex(int x, int y) {
			this.x = x;
			this.y = y;
			this.id = id(x, y);
			this.connectedVertices = new HashSet<>();
		}

		public static String id(int x, int y) {
			return String.format("(%d, %d)", x, y);
		}
	}
}
