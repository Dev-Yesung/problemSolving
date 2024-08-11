package programmers;

import java.util.*;

public class Programmers49993_1 {
	public static void main(String[] args) {
		int answer = new Programmers49993_1()
			.solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA"});
		System.out.println(answer);
	}

	public int solution(String skill, String[] skillTrees) {
		char[] sks = skill.toCharArray();
		Map<Character, Integer> skillMap = new HashMap<>();
		for (int i = 0; i < sks.length; i++) {
			char s = sks[i];
			skillMap.put(s, i);
		}

		int answer = 0;
		for (String skillTree : skillTrees) {
			boolean[] isFinished = new boolean[sks.length];
			char[] skills = skillTree.toCharArray();
			boolean isExit = false;
			for (int i = 0; i < skills.length; i++) {
				char elem = skills[i];
				if (skillMap.containsKey(elem)) {
					int step = skillMap.get(elem);
					for (int j = 0; j < step; j++) {
						if (!isFinished[j]) {
							isExit = true;
							break;
						}
					}

					if (isExit) {
						break;
					}

					isFinished[step] = true;
				}
			}
			if (isExit) {
				continue;
			}

			answer++;
		}

		return answer;
	}

}
