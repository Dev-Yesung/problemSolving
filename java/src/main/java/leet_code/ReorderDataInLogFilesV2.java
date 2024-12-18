package leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReorderDataInLogFilesV2 {

	public static void main(String[] args) {
		String[] answer = new ReorderDataInLogFilesV2()
			.reorderLogFiles(new String[] {
				"dig1 8 1 5 1",
				"let1 art can",
				"dig2 3 6",
				"let2 own kit dig",
				"let3 art zero"
			});
		System.out.println(Arrays.toString(answer));
	}

	public String[] reorderLogFiles(String[] logs) {
		List<String> letterLogs = new ArrayList<>();
		List<String> digitLogs = new ArrayList<>();
		for (String log : logs) {
			if (Character.isDigit(log.split(" ")[1].charAt(0))) {
				digitLogs.add(log);
			} else {
				letterLogs.add(log);
			}
		}

		letterLogs.sort((s1, s2) -> {
			String[] s1Tokens = s1.split(" ", 2);
			String[] s2Tokens = s2.split(" ", 2);
			int compared = s1Tokens[1].compareTo(s2Tokens[1]);
			if (compared == 0) {
				return s1Tokens[0].compareTo(s2Tokens[0]);
			} else {
				return compared;
			}
		});
		letterLogs.addAll(digitLogs);

		return letterLogs.toArray(String[]::new);
	}
}
