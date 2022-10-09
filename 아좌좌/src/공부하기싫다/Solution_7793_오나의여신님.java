package 공부하기싫다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_7793_오나의여신님 {
	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, answer;
	static char[][] map;
	static int[][] visit;
	static Queue<Point> Q, syQ;
	static Point start, dest, devil;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new char[N][M];
			visit = new int[N][M];
			Q = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 'D') {
						dest = new Point(i, j);
					}
					if (map[i][j] == 'S') {
						start = new Point(i, j);
					}
					if (map[i][j] == '*') {
						devil = new Point(i, j);
						Q.add(devil);
					}
				}
			}

			answer = Integer.MAX_VALUE;
			bfs();

			if (visit[dest.x][dest.y] == 0) {
				System.out.println("#" + tc + " GAME OVER");
			} else {
				System.out.println("#" + tc + " " + answer);
			}
		}
	}

	private static void bfs() {
		syQ = new LinkedList<>();
		syQ.add(start);

		while (!syQ.isEmpty()) {
			int size = Q.size();

			for (int s = 0; s < size; s++) {
				Point cur = Q.poll();

				for (int d = 0; d < 4; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];

					if (nx < 0 || ny < 0 || nx >= N || ny >= M)
						continue;

					if (map[nx][ny] == '.') {
						Q.add(new Point(nx, ny));
						map[nx][ny] = '*';
					}
				}
			}

			// 수연이 이동할게
			size = syQ.size();
			for (int s = 0; s < size; s++) {
				Point cur = syQ.poll();

				for (int d = 0; d < 4; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];

					if (nx < 0 || ny < 0 || nx >= N || ny >= M)
						continue;

					if (map[nx][ny] == '.' && visit[nx][ny] == 0) {
						syQ.add(new Point(nx, ny));
						visit[nx][ny] = visit[cur.x][cur.y] + 1;
					}
					if (map[nx][ny] == 'D') {
						visit[nx][ny] = visit[cur.x][cur.y] + 1;
						answer = Math.min(answer, visit[nx][ny]);
					}
				}
			}

		}

	}

}
