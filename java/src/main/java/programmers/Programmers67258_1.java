package programmers;

import java.util.*;
import java.util.stream.Collectors;

class Programmers67258_1 {

	public int[] solution(final String[] gems) {
		final Set<String> gemType = Arrays.stream(gems)
			.collect(Collectors.toSet());
		final int endIdx = calculateEndIdx(gems, gemType);
		final Map<String, Integer> gemMap = getGemMap(gems, endIdx);
		final int startIdx = calculateStartIdx(gems, endIdx, gemMap);

		return new int[] {startIdx + 1, endIdx + 1};
	}

	private int calculateEndIdx(final String[] gems, final Set<String> gemType) {
		int endIdx = 0;
		final Set<String> resultSet = new HashSet<>();
		for (int i = 0; i < gems.length; i++) {
			resultSet.add(gems[i]);
			if (gemType.equals(resultSet)) {
				endIdx = i;
				break;
			}
		}

		return endIdx;
	}

	private Map<String, Integer> getGemMap(final String[] gems, final int endIdx) {
		final Map<String, Integer> gemMap = new HashMap<>();
		for (int i = 0; i <= endIdx; i++) {
			gemMap.put(gems[i], gemMap.getOrDefault(gems[i], 0) + 1);
		}

		return gemMap;
	}

	private int calculateStartIdx(final String[] gems, final int endIdx,
		final Map<String, Integer> gemMap) {
		int startIdx = 0;
		for (int i = 0; i <= endIdx; i++) {
			final int count = gemMap.get(gems[i]);
			if (count - 1 == 0) {
				startIdx = i;
				break;
			}
			gemMap.put(gems[i], count - 1);
		}

		return startIdx;
	}
}
