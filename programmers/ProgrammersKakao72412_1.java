import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/72412
// 순위 검색
public class ProgrammersKakao72412_1 {

	public int[] solution(String[] info, String[] query) {
		Map<String, List<Integer>> scoresMap = buildScoresMap(info);
		int[] answer = new int[query.length];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = count(query[i], scoresMap);
		}

		return answer;
	}

	Map<String, List<Integer>> buildScoresMap(String[] info) {
		Map<String, List<Integer>> scoresMap = new HashMap<>();
		for (String s : info) {
			String[] tokens = s.split(" ");
			int score = Integer.parseInt(tokens[tokens.length - 1]);

			forEachKey(0, "", tokens, scoresMap, score);
		}
		for (List<Integer> list : scoresMap.values()) {
			Collections.sort(list);
		}

		return scoresMap;
	}

	void forEachKey(int index, String prefix, String[] tokens, Map<String, List<Integer>> scoresMap, int score) {
		if (index == tokens.length - 1) {
			scoresMap.putIfAbsent(prefix, new ArrayList<>());
			scoresMap.get(prefix).add(score);

			return;
		}

		forEachKey(index + 1, prefix + tokens[index], tokens, scoresMap, score);
		forEachKey(index + 1, prefix + "-", tokens, scoresMap, score);
	}

	int count(String query, Map<String, List<Integer>> scoresMap) {
		String[] tokens = query.split(" (and )?");
		String key = String.join("", Arrays.copyOf(tokens, tokens.length - 1));
		if (!scoresMap.containsKey(key)) {
			return 0;
		}

		List<Integer> scores = scoresMap.get(key);
		int score = Integer.parseInt(tokens[tokens.length - 1]);

		return scores.size() - binarySearch(score, scoresMap.get(key));
	}

	int binarySearch(int score, List<Integer> scores) {
		// 범위에 있는 수들 중에 score와 같거나 큰 최초의 인덱스를 찾아야 한다.
		// [start, end]
		int start = 0;
		int end = scores.size() - 1;

		while (end > start) {
			int mid = (start + end) / 2;

			if (scores.get(mid) >= score) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		if (scores.get(start) < score) {
			return start + 1;
		}

		return start;
	}

}
