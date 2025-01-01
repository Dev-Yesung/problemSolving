package leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagramsV2 {

	public static void main(String[] args) {
		final List<List<String>> answer = new GroupAnagramsV2()
			.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
		System.out.println(answer);
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> results = new HashMap<>();
		for (String s :  strs) {
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			String key = String.valueOf(chars);
			if (!results.containsKey(key)) {
				results.put(key, new ArrayList<>());
			}
			results.get(key).add(s);
		}

		return new ArrayList<>(results.values());
	}
}
