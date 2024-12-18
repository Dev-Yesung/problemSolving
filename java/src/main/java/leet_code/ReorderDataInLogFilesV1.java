package leet_code;

import java.util.Arrays;

public class ReorderDataInLogFilesV1 {

	public static void main(String[] args) {
		String[] answer = new ReorderDataInLogFilesV1()
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
		return Arrays.stream(logs)
			.map(it -> {
				String[] tokens = it.split(" ");
				if (Character.isDigit(tokens[1].toCharArray()[0])) {
					return new Log(
						LogType.DIGIT,
						tokens[0],
						it.replaceFirst(tokens[0] + " ", ""));
				} else {
					return new Log(
						LogType.LETTER,
						tokens[0],
						it.replaceFirst(tokens[0] + " ", ""));
				}
			})
			.sorted((o1, o2) -> {
				if (o1.type == LogType.LETTER && o2.type == LogType.LETTER) {
					if (o1.data.equals(o2.data)) {
						return o1.id.compareTo(o2.id);
					} else {
						return o1.data.compareTo(o2.data);
					}
				} else if (o1.type == LogType.LETTER && o2.type == LogType.DIGIT) {
					return -1;
				} else if (o1.type == LogType.DIGIT && o2.type == LogType.LETTER) {
					return 1;
				} else {
					return 0;
				}
			})
			.map(it -> it.id + " " + it.data)
			.toArray(String[]::new);
	}

	private enum LogType {DIGIT, LETTER}

	private static class Log {
		public LogType type;
		public String id;
		public String data;

		public Log(LogType type, String id, String data) {
			this.type = type;
			this.id = id;
			this.data = data;
		}
	}
}
