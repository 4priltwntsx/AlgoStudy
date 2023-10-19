package bdfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926_그림 {
	static class Point {
		int i, j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static int[] di = { 1, -1, 0, 0 };
	static int[] dj = { 0, 0, 1, -1 };
	static int N, M, map[][], visit[][];
	static int count, max_size;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 새로크기
		M = Integer.parseInt(st.nextToken()); // 가로크기
		map = new int[N][M];
		visit = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && visit[i][j] == 0) {
					count++;
					max_size = Math.max(bfs(i, j), max_size);
				}
			}
		}
		System.out.println(count);
		System.out.println(max_size);
	}

	public static int bfs(int i, int j) {
		Queue<Point> Q = new LinkedList<>();
		Q.add(new Point(i, j));
		visit[i][j] = 1;
		int size = 1;
		while (!Q.isEmpty()) {
			Point cur = Q.poll();

			for (int d = 0; d < 4; d++) {
				int ni = cur.i + di[d];
				int nj = cur.j + dj[d];

				if (ni < 0 || nj < 0 || ni >= N || nj >= M)
					continue;
				if (visit[ni][nj] == 1)
					continue;
				if (map[ni][nj] == 0)
					continue;

				Q.add(new Point(ni, nj));
				visit[ni][nj] = 1;
				size++;
			}
		}
		return size;
	}
}
