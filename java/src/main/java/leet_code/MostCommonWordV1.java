package leet_code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MostCommonWordV1 {

	public static void main(String[] args) {
		final String answer = new MostCommonWordV1()
			.mostCommonWord(
				"Bob hit a ball, the hit BALL flew far after it was hit.",
				new String[] {"hit"}
			);
		System.out.println(answer);
	}

	public String mostCommonWord(String paragraph, String[] banned) {
		final Set<String> bannedWords = Arrays.stream(banned)
			.collect(Collectors.toSet());
		final String lowerCaseParagraph = paragraph.toLowerCase();
		final String[] wordTokens = lowerCaseParagraph.split("[!?,;.'\\s]+");
		final Map<String, Integer> wordCountMap = new HashMap<>();
		for (final String word : wordTokens) {
			if (bannedWords.contains(word)) {
				continue;
			}
			wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
		}

		return wordCountMap.entrySet()
			.stream()
			.max((e1, e2) -> e1.getValue() - e2.getValue())
			.get()
			.getKey();
	}
}
