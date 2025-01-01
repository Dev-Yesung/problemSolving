package leet_code;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWordV2 {

	public static void main(String[] args) {
		final String answer = new MostCommonWordV2()
			.mostCommonWord(
				"Bob hit a ball, the hit BALL flew far after it was hit.",
				new String[] {"hit"}
			);
		System.out.println(answer);
	}

	public String mostCommonWord(String paragraph, String[] banned) {
		final Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
		final String cleansedParagraph = paragraph.toLowerCase().replaceAll("\\W", " ");
		final String[] wordTokens = cleansedParagraph.split(" +");
		final Map<String, Integer> countMap = new HashMap<>();
		for (String word : wordTokens) {
			if (bannedWords.contains(word)) {
				continue;
			}
			countMap.put(word, countMap.getOrDefault(word, 0) + 1);
		}

		return Collections.max(countMap.entrySet(), Map.Entry.comparingByValue())
			.getKey();
	}
}
