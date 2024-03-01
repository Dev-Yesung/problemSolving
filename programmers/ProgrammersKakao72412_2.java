import java.util.*;
import java.util.function.*;

// 순위검색 문제에 Consumer 를 적용해서 개선한 코드
public class ProgrammersKakao72412_2 {

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

			forEachKey(0, "", tokens, key -> {
				scoresMap.putIfAbsent(key, new ArrayList<>());
				scoresMap.get(key).add(score);
			});
		}
		for (List<Integer> list : scoresMap.values()) {
			Collections.sort(list);
		}

		return scoresMap;
	}

	void forEachKey(int index, String prefix, String[] tokens, Consumer<String> action) {
		if (index == tokens.length - 1) {
			action.accept(prefix);

			return;
		}

		forEachKey(index + 1, prefix + tokens[index], tokens, action);
		forEachKey(index + 1, prefix + "-", tokens, action);
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
		int start = 0; // inclusive
		int end = scores.size() - 1; // inclusive

		while (end > start) {
			int mid = (start + end) / 2;

			if (scores.get(mid) >= score) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		if (scores.get(start) < score) {
			return scores.size();
		}

		return start;
	}

}
