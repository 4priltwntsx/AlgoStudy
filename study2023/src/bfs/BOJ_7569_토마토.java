package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_토마토 {
	static class Point {
		int h, i, j;

		Point(int h, int i, int j) {
			this.i = i;
			this.j = j;
			this.h = h;
		}
	}

	static int[] di = { 1, -1, 0, 0, 0, 0 };
	static int[] dj = { 0, 0, 1, -1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, 1, -1 };
	static int M, N, H;
	static int[][][] visit, map; // 높이, 가로 세로
	static Queue<Point> Q;
	static int unripe, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		visit = new int[H][N][M];
		map = new int[H][N][M];
		unripe = 0;
		Q = new LinkedList<>();
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[h][i][j] = Integer.parseInt(st.nextToken());
					if (map[h][i][j] == 1)
						Q.add(new Point(h, i, j));
					else if (map[h][i][j] == 0)
						unripe++;
				}
			}
		}
		if (unripe == 0) {
			System.out.print(0);
		} else {
			bfs();
			System.out.println(unripe > 0 ? -1 : answer-1); // 모든 토마토가 익고 나서도 answer++가 되므로
		}

	}

	public static void bfs() {

		while (!Q.isEmpty()) {
			int size = Q.size();

			for (int s = 0; s < size; s++) {
				Point cur = Q.poll();
				for (int d = 0; d < 6; d++) {
					int ni = cur.i + di[d];
					int nj = cur.j + dj[d];
					int nh = cur.h + dh[d];

					if (ni < 0 || nj < 0 || nh < 0 || ni >= N || nj >= M || nh >= H)
						continue;
					if (map[nh][ni][nj] == -1)
						continue;
					if (visit[nh][ni][nj] == 1)
						continue;
					if (map[nh][ni][nj] == 0) {
						Q.add(new Point(nh, ni, nj));
						visit[nh][ni][nj] = 1;
						unripe--;
					}
				}
			}
			answer++;
		}
	}
}
