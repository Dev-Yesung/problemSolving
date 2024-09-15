package programmers;

import java.util.*;

class Programmers67258_2 {
	public int[] solution(final String[] gems) {
		int startIdx = 0;
		int endIdx = gems.length - 1;
		final Set<String> gemSet = new HashSet<>(List.of(gems));
		int s = 0;
		int e = 0;
		final Map<String, Integer> gemCounteMap = new HashMap<>();
		gemCounteMap.put(gems[0], 1);

		while (s < gems.length) {
			if (gemCounteMap.keySet().size() == gemSet.size()) {
				if (e - s < endIdx - startIdx) {
					startIdx = s;
					endIdx = e;
				}

				gemCounteMap.put(gems[s], gemCounteMap.get(gems[s]) - 1);
				if (gemCounteMap.get(gems[s]) == 0) {
					gemCounteMap.remove(gems[s]);
				}
				s++;
			} else if (e < gems.length - 1) {
				e++;
				gemCounteMap.put(gems[e], gemCounteMap.getOrDefault(gems[e], 0) + 1);
			} else {
				break;
			}
		}

		return new int[] {startIdx + 1, endIdx + 1};
	}
}
