import java.util.*;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/87377

    1. 모든 직선에 관해 교점을 찾는다.
        1-1 AD-BC로 교점이 존재하는지 판단
        1-2 교점이 존재한다면, 공식으로 교점을 찾는다.
        1-3 교점이 정수인지 판단하고 정수라면 저장해놓는다.
    2. x의 최대값, 최소값과 y의 최대값, 최소값을 구해서 배열을 만든다.
    3. 저장된 위치를 기반으로 별을 배열에 찍는다.
*/

public class Programmers87377_2 {
	public String[] solution(int[][] line) {
		List<Point> points = findTransactionPoints(line);
		Point maxPoint = findMaxPoint(points);
		Point minPoint = findMinPoint(points);
		char[][] mat = makeMatrix(maxPoint, minPoint);
		markStars(mat, maxPoint, minPoint, points);
		String[] answer = covertToStringMatrix(mat);

		return answer;
	}

	private List<Point> findTransactionPoints(int[][] line) {
		List<Point> points = new ArrayList<>();
		int rowLength = line.length;
		for (int row = 0; row < rowLength; row++) {
			for (int nxt = row + 1; nxt < rowLength; nxt++) {
				long a = line[row][0];
				long b = line[row][1];
				long e = line[row][2];

				long c = line[nxt][0];
				long d = line[nxt][1];
				long f = line[nxt][2];

				long det = (long)(a * d - b * c);
				if (det == 0) {
					continue;
				}

				double x = (double)(b * f - e * d) / det;
				double y = (double)(e * c - a * f) / det;
				if (!(isInteger(x) && isInteger(y))) {
					continue;
				}

				points.add(new Point((long)x, (long)y));
			}
		}

		return points;
	}

	private boolean isInteger(double number) {
		return number % 1 == 0.0;
	}

	private Point findMaxPoint(List<Point> points) {
		long maxX = Long.MIN_VALUE;
		long maxY = Long.MIN_VALUE;

		for (Point p : points) {
			maxX = Math.max(maxX, p.x);
			maxY = Math.max(maxY, p.y);
		}

		return new Point(maxX, maxY);
	}

	private Point findMinPoint(List<Point> points) {
		long minX = Long.MAX_VALUE;
		long minY = Long.MAX_VALUE;

		for (Point p : points) {
			minX = Math.min(minX, p.x);
			minY = Math.min(minY, p.y);
		}

		return new Point(minX, minY);
	}

	private char[][] makeMatrix(Point maxPoint, Point minPoint) {
		int height = (int)(maxPoint.y - minPoint.y + 1);
		int width = (int)(maxPoint.x - minPoint.x + 1);
		char[][] mat = new char[height][width];

		for (int i = 0; i < height; i++) {
			Arrays.fill(mat[i], '.');
		}

		return mat;
	}

	private void markStars(char[][] mat, Point maxPoint, Point minPoint, List<Point> points) {
		for (Point p : points) {
			int xPos = (int)(p.x - minPoint.x);
			int yPos = (int)(maxPoint.y - p.y);
			mat[yPos][xPos] = '*';
		}
	}

	private String[] covertToStringMatrix(char[][] mat) {
		String[] strMat = new String[mat.length];
		for (int i = 0; i < mat.length; i++) {
			strMat[i] = new String(mat[i]);
		}

		return strMat;
	}

	static class Point {
		public long x;
		public long y;

		Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
}
