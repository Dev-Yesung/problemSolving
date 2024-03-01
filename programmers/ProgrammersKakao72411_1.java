import java.util.*;
import java.util.stream.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/72411
// 메뉴 리뉴얼

public class ProgrammersKakao72411_1 {

	public static void main(String[] args) {
		String[] answer = new ProgrammersKakao72411_1()
			.solution(
				new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
				new int[] {2, 3, 4}
			);

		System.out.println(Arrays.toString(answer));
	}

	public String[] solution(String[] orders, int[] course) {
		List<Set<String>> orderList = Arrays.stream(orders)
			.map(String::chars)
			.map(charStream -> charStream
				.mapToObj(menu -> String.valueOf((char)menu))
				.collect(Collectors.toSet()))
			.collect(Collectors.toList());

		Map<Integer, List<Course>> courses = new HashMap<>();
		for (int length : course) {
			List<Course> list = new ArrayList<>();
			list.add(new Course("", 0));
			courses.put(length, list);
		}

		getCourses('A', new HashSet<>(), orderList, courses);

		return courses.values()
			.stream()
			.filter(list -> list.get(0).occurrences > 0)
			.flatMap(List::stream)
			.map(c -> c.course)
			.sorted()
			.toArray(String[]::new);
	}

	private void getCourses(
		char nextMenu,
		Set<String> selectedMenus,
		List<Set<String>> orderList,
		Map<Integer, List<Course>> courses
	) {
		// 현재 선택한 조합이 주문한 메뉴 리스트에서 몇 번 나왔는지 체크
		int occurrences = (int)orderList.stream()
			.filter(order -> order.containsAll(selectedMenus))
			.count();

		// 만일 2번 이상 나오지 않았다면 더 이상 체크하지 않아도 되는 조합이므로 제외
		if (occurrences < 2) {
			return;
		}

		int size = selectedMenus.size();
		if (courses.containsKey(size)) {
			List<Course> courseList = courses.get(size);
			Course course = new Course(selectedMenus.stream()
				.sorted()
				.collect(Collectors.joining("")), occurrences);
			Course original = courseList.get(0);
			if (original.occurrences < occurrences) {
				courseList.clear();
				courseList.add(course);
			} else if (original.occurrences == occurrences) {
				courseList.add(course);
			}
		}

		// 메뉴 조합은 10개까지 가능하므로 size가 10이상부터는 조합을 끝내야 한다.
		if (size >= 10) {
			return;
		}

		// 다음 메뉴를 선택하여
		for (char menuChar = nextMenu; menuChar <= 'Z'; menuChar++) {
			String menu = String.valueOf(menuChar);
			selectedMenus.add(menu);
			getCourses((char)(menuChar + 1), selectedMenus, orderList, courses);
			selectedMenus.remove(menu);
		}
	}

	static class Course {
		public final String course;
		public final int occurrences;

		public Course(String course, int occurrences) {
			this.course = course;
			this.occurrences = occurrences;
		}
	}

}
