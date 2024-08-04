package programmers;

import java.util.*;

// 풀이 방법이 바로 생각났음 -> 답을 구하는 거 자체는 학부 때 많이 해봤던 Traversal 문제임
// 다만, 오히려 트리 구성하는 거 자체가 더 까다로운 듯
// 하지만 y 좌표로 정렬한 후 구성하면 된다는 것을 캐치해서 풀었음

public class Programmers42892 {
	// ** 추가 : 배열로도 가능할 거 같음.

	public int[][] solution(int[][] nodeInfos) {
		Node[] nodes = new Node[nodeInfos.length];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(i + 1, nodeInfos[i][0], nodeInfos[i][1]);
		}
		Arrays.sort(nodes, (node1, node2) -> node2.y - node1.y);

		Node root = constructTree(nodes);

		List<Integer> preOrderVisits = new ArrayList<>();
		preOrder(root, preOrderVisits);

		List<Integer> postOrderVisits = new ArrayList<>();
		postOrder(root, postOrderVisits);

		return new int[][] {preOrderVisits.stream()
			.mapToInt(Integer::valueOf)
			.toArray(), postOrderVisits.stream()
			.mapToInt(Integer::valueOf)
			.toArray()};
	}

	private Node constructTree(Node[] nodes) {
		Node root = nodes[0];

		for (int i = 1; i < nodes.length; i++) {
			insert(root, nodes[i]);
		}

		return root;
	}

	private void insert(Node root, Node node) {
		if (node.x < root.x) {
			if (root.left == null) {
				root.left = node;
			} else {
				insert(root.left, node);
			}
		} else {
			if (root.right == null) {
				root.right = node;
			} else {
				insert(root.right, node);
			}
		}
	}

	private void preOrder(Node node, List<Integer> visits) {
		if (node == null) {
			return;
		}

		visits.add(node.value);
		preOrder(node.left, visits);
		preOrder(node.right, visits);
	}

	private void postOrder(Node node, List<Integer> visits) {
		if (node == null) {
			return;
		}

		postOrder(node.left, visits);
		postOrder(node.right, visits);
		visits.add(node.value);
	}

	private static class Node {
		public final int value;
		public final int x;
		public final int y;

		public Node left;
		public Node right;

		public Node(int value, int x, int y) {
			this.value = value;
			this.x = x;
			this.y = y;
		}
	}
}
