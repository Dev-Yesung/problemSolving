import java.util.*;

// 정규표현식 사용해 불령 사용자 아이디 목록에 해당하는 사용자 아이디를 구한다.
// 구한 사용자 아이디로 조합할 수 있는 경우의 수를 구한다.

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

		Set<Set<String>> banSet = new HashSet<>();
		count(0, new HashSet<>(), bans, banSet);

		return banSet.size();
	}

	void count(int index, Set<String> banned, String[][] bans, Set<Set<String>> banSet) {
		if (index == bans.length) {
			banSet.add(new HashSet<>(banned));
			return;
		}

		for (String id : bans[index]) {
			if (banned.contains(id)) {
				continue;
			}

			banned.add(id);
			count(index + 1, banned, bans, banSet);
			banned.remove(id);
		}
	}
}
