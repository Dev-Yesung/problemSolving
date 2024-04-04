import java.util.Arrays;

// 정규표현식을 어느 정도 다룰줄 알아야 할 필요를 느낀다..!

public class Programmers49993_2 {

	public static void main(String[] args) {
		int answer = new Programmers49993_1()
			.solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA"});
		System.out.println(answer);
	}

	public int solution(String skill, String[] skillTrees) {
		return (int)Arrays.stream(skillTrees)
			.map(s -> s.replaceAll("[^" + skill + "]", ""))
			.filter(skill::startsWith)
			.count();
	}

}
