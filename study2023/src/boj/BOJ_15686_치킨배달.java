package boj;

import java.util.*;
import java.io.*;

public class BOJ_15686_치킨배달 {
	static int N, M, answer;
	static ArrayList<Point> chickens, houses;
	static Point select[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		chickens = new ArrayList<>();
		houses = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int point = Integer.parseInt(st.nextToken());
				if (point == 1)
					houses.add(new Point(i, j));
				else if (point == 2)
					chickens.add(new Point(i, j));
			}
		} // input end
		select = new Point[M]; // 1개 익상 M개 최대
		answer = Integer.MAX_VALUE;
		dfs(0, 0);
		System.out.println(answer);

	}

	static void dfs(int cnt, int idx) {
		if (cnt == M || idx == chickens.size()) { // 최대 M개를 골랐거나, 모든 치킨집 dfs를 다 돌았을 때
			int sum = 0;
			for (Point house : houses) {
				int dist = Integer.MAX_VALUE;
				for (Point s : select) {
					int temp = calcualtor(house, s);
					if (dist > temp)
						dist = temp;
				}
				sum += dist;
			}
			if (answer > sum)
				answer = sum;
			return;
		}

		select[cnt] = chickens.get(idx); // 현재 인덱스의 치킨 좌표 선택
		dfs(cnt + 1, idx + 1);
		dfs(cnt, idx + 1); // 부분집합 구하니까 cnt 증가 안하는 경우도 고려
	}

	static int calcualtor(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
