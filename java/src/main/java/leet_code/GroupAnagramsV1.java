package leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsV1 {

	public static void main(String[] args) {
		final List<List<String>> answer = new GroupAnagramsV1()
			.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
		System.out.println(answer);
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		final Map<String, List<String>> answerMap = new HashMap<>();
		for (String str : strs) {
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);
			String key = String.valueOf(charArray);
			if (answerMap.containsKey(key)) {
				final List<String> answers = answerMap.get(key);
				answers.add(str);
			} else {
				final List<String> answers = new ArrayList<>();
				answers.add(str);
				answerMap.put(key, answers);
			}
		}

		return new ArrayList<>(answerMap.values());
	}
}
