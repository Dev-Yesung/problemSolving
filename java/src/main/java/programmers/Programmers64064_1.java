import java.util.*;

public class Programmers64064_1 {

	public static void main(String[] args) {
		int answer = new Programmers64064_1()
			.solution(
				new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"},
				new String[] {"fr*d*", "*rodo", "******", "******"}
			);

		System.out.println(answer);
	}

	Map<String, Boolean> isUsed = new HashMap<>();
	Set<String[]> candidates = new HashSet<>();

	public int solution(String[] userIds, String[] bannedIds) {
		List<Set<String>> list = new ArrayList<>();
		for (String bannedId : bannedIds) {
			Set<String> comb = getCandidate(userIds, bannedId);

			list.add(comb);
		}

		for (String userId : userIds) {
			isUsed.put(userId, false);
		}

		getAnswer(list, 0, new String[bannedIds.length]);

		List<Set<String>> answer = new ArrayList<>();
		for (String[] arr : candidates) {
			Set<String> s = new HashSet<>(Arrays.asList(arr));
			if (!answer.contains(s)) {
				answer.add(s);
			}
		}

		return answer.size();
	}

	void getAnswer(List<Set<String>> list, int cur, String[] candidate) {
		if (cur == list.size()) {
			candidates.add(Arrays.copyOf(candidate, cur));
			return;
		}

		// list의 현재 위치에 있는 집합을 가져옴
		Set<String> s = list.get(cur);
		for (String str : s) {
			if (isUsed.get(str)) {
				continue;
			}

			// 집합에서 글자 하나를 꺼냄
			candidate[cur] = str;
			isUsed.put(str, true);
			getAnswer(list, cur + 1, candidate);  // 다음 집합으로 넘어감
			isUsed.put(str, false);
		}

	}

	Set<String> getCandidate(String[] userIds, String bannedId) {
		Set<String> candidate = new HashSet<>();

		for (String userId : userIds) {
			boolean isCandidate = true;

			// 1. 각 아이디의 길이 비교
			if (userId.length() != bannedId.length()) {
				continue;
			}

			// 2. *을 제외한 위치에서 아이디의 글자가 동일한가?
			for (int i = 0; i < bannedId.length(); i++) {
				if (bannedId.charAt(i) == '*') {
					continue;
				}
				if (userId.charAt(i) != bannedId.charAt(i)) {
					isCandidate = false;
					break;
				}
			}
			if (!isCandidate) {
				continue;
			}

			// 3. userId를 set에 추가
			candidate.add(userId);
		}

		return candidate;
	}

}
