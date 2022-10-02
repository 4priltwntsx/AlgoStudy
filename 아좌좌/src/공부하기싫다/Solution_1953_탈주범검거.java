package 공부하기싫다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {

	static class Point {
		int x, y;
		int type;

		Point(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}

	static int[] dx = { -1, 1, 0, 0 }; // 상 하
	static int[] dy = { 0, 0, -1, 1 }; // 좌 우

	static int[][] type = { {}, { 0, 1, 2, 3 }, { 0, 1 }, { 2, 3 }, { 0, 3 }, { 1, 3 }, { 1, 2 }, { 0, 2 } };

	static int[][] map, visit;

	static int N, M, R, C, L, answer; // 세로, 가로, 맨홀좌표, 소요된 시간.

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visit = new int[N][M];
			int mtype = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (i == R && j == C) {
						mtype = map[i][j];
					}
				}
			}
			answer = 1;
			bfs(R, C, mtype);
			System.out.println("#"+tc+" "+answer);

		}
	}

	private static void bfs(int x, int y, int t) {

		Queue<Point> Q = new LinkedList<>();
		Q.add(new Point(x, y, t));
		int cnt = 1;
		visit[x][y] = 1;

		while (!Q.isEmpty()) {
			if (cnt == L)
				return;

			int size = Q.size();

			for (int s = 0; s < size; s++) {
				Point cur = Q.poll();
				for (int i : type[cur.type]) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];

					if (nx < 0 || ny < 0 || nx >= N || ny >= M)
						continue;
					if (map[nx][ny] == 0)
						continue;
					if (visit[nx][ny] == 1)
						continue;

					int ni = i % 2 == 0 ? i + 1 : i - 1;

					if (dirCheck(ni, map[nx][ny])) { // 방향 갈 수 있으면
						visit[nx][ny] = 1;
						answer++;
						Q.add(new Point(nx, ny, map[nx][ny]));
					}

				}
			}
			cnt++;
		}

	}

	private static boolean dirCheck(int dir, int t) {
		for (int i : type[t]) {
			if (i == dir)
				return true;
		}
		return false;
	}
}
