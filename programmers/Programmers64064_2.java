import java.util.*;

// 정규표현식 사용해 불령 사용자 아이디 목록에 해당하는 사용자 아이디를 구한다.
// 구한 사용자 아이디로 조합할 수 있는 경우의 수를 구한다.

// 내가 처음 풀었던 방식과 동일하긴 하나, 내 코드에서 문제가 생긴부분이 있었다!
// 정규표현식으로 리스트를 만드는 방법은 엄청 유용하다. 이왕이면 외우자.

public class Programmers64064_2 {
	public static void main(String[] args) {
		int answer = new Programmers64064_2()
			.solution(
				new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"},
				new String[] {"fr*d*", "*rodo", "******", "******"}
			);

		System.out.println(answer);
	}

	public int solution(String[] userIds, String[] bannedIds) {
		String[][] bans = Arrays.stream(bannedIds)
			.map(banned -> banned.replace('*', '.'))
			.map(banned -> Arrays.stream(userIds)
				.filter(id -> id.matches(banned))
				.toArray(String[]::new)
			)
			.toArray(String[][]::new);

		for (String[] ban : bans) {
			System.out.println("candidate : " + Arrays.toString(ban));
		}

		Set<Set<String>> answerSet = new HashSet<>();
		count(0, new HashSet<>(), bans, answerSet);

		for (Set<String> set : answerSet) {
			Object[] arr = set.toArray();
			Arrays.sort(arr);
			System.out.println("answer: " + Arrays.toString(arr));
		}

		return answerSet.size();
	}

	void count(int index, Set<String> candidate, String[][] bans, Set<Set<String>> answerSet) {
		if (index == bans.length) {
			answerSet.add(new HashSet<>(candidate));
			return;
		}

		for (String id : bans[index]) {
			if (candidate.contains(id)) {
				continue;
			}

			candidate.add(id);
			count(index + 1, candidate, bans, answerSet);
			candidate.remove(id);
		}
	}
}
