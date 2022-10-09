package 공부하기싫다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2105_디저트카페 {
	static class Point {
		int i, j;
		int type;

		Point(int i, int j, int type) {
			this.i = i;
			this.j = j;
			this.type = type;
		}
	}

	static int N, answer;
	static int[][] map;
	static int[] visit;
	static int[] di = { -1, -1, 1, 1 };
	static int[] dj = { -1, 1, 1, -1 };
	static int[][] type = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			answer = -1;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visit = new int[101];
					dfs(new Point(i, j, 2), i, j, 2, 0);
				}
			}
			
			System.out.println("#"+tc+" " +answer);
		}
	}

	static void dfs(Point start, int nowi, int nowj, int dir, int cnt) {

		if (dir == 1 && nowi == start.i && nowj == start.j) {
			if (answer < cnt)
				answer = cnt;
		}

		for (int t : type[dir]) {
			int ni = nowi + di[t];
			int nj = nowj + dj[t];

			if (ni < 0 || nj < 0 || ni >= N || nj >= N)  continue;
			
			int dessert = map[ni][nj];
			
			if(visit[dessert] == 1) continue;
			
			visit[dessert] = 1;
			dfs(start, ni, nj, t, cnt+1);
			visit[dessert] = 0;
			
		}
	}
}
