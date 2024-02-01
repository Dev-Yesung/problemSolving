package ps;

import java.io.*;
import java.util.*;

public class Boj1406 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static List<Character> textLines = new LinkedList<>();
	static ListIterator<Character> cursor;

	public static void main(String[] args) throws IOException {
		String input = br.readLine();
		for (Character ch : input.toCharArray()) {
			textLines.add(ch);
		}

		cursor = textLines.listIterator();
		while (cursor.hasNext()) {
			cursor.next();
		}

		int cmdCounter = Integer.parseInt(br.readLine());
		for (int i = 0; i < cmdCounter; ++i) {
			String cmd = br.readLine();
			String[] param = cmd.split(" ");

			switch (param[0]) {
				case "L" -> moveLeft();
				case "D" -> moveRight();
				case "B" -> deleteLeft();
				case "P" -> addLeft(param[1]);
			}
		}

		printAll();
	}

	static void moveLeft() {
		if (cursor.hasPrevious()) {
			cursor.previous();
		}
	}

	static void moveRight() {
		if (cursor.hasNext()) {
			cursor.next();
		}
	}

	static void deleteLeft() {
		if (!cursor.hasPrevious()) {
			return;
		}
		moveLeft();
		cursor.remove();
	}

	static void addLeft(String ch) {
		if (ch.isEmpty()) {
			return;
		}
		cursor.add(ch.charAt(0));
	}

	static void printAll() {
		textLines.forEach(sb::append);
		System.out.println(sb.toString());
	}
}
