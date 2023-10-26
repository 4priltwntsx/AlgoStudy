import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point {
		int i, j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static int[] di = { 1, -1, 0, 0 };
	static int[] dj = { 0, 0, 1, -1 };
	static int N, M, map[][], count[][], visit[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new int[N][M];
		count = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int year =0 ;
		while (true) {
			// 인접한 바다 개수 구하기
			count_sea();

			// 빙산 - 바다 개수
			int tmp = calculate();
			if(tmp==N*M) {
				year = 0;
                break;
			}

			// 덩어리 탐색
			int cnt = 0;
			visit = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0 && visit[i][j]==0) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			year++;
			if (cnt >= 2) {
				break;
			}
		}
		
		System.out.println(year);
	}

	private static void bfs(int i, int j) {
		Queue<Point> Q = new LinkedList<>();
		Q.add(new Point(i, j));
		visit[i][j] = 1;

		while (!Q.isEmpty()) {
			Point cur = Q.poll();

			for (int d = 0; d < 4; d++) {
				int ni = cur.i + di[d];
				int nj = cur.j + dj[d];

				if (ni <= 0 || nj <= 0 || ni > N || nj > M)
					continue;
				if (visit[ni][nj] != 0)
					continue;
				if (map[ni][nj] == 0)
					continue;

				Q.add(new Point(ni, nj));
				visit[ni][nj] = 1;
			}
		}
	}

	private static int calculate() {
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && count[i][j] != 0) {
					map[i][j] -= count[i][j];
					if (map[i][j] < 0)
						map[i][j] = 0;
				}
				if(map[i][j]==0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static void count_sea() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					int cnt = 0;
					for (int d = 0; d < 4; d++) {
						int ni = i + di[d];
						int nj = j + dj[d];
						if (ni < 0 || nj < 0 || ni >= N || nj >= M)
							continue;
						if (map[ni][nj] == 0)
							cnt++;
					}
					count[i][j] = cnt;
				}
			}
		}
	}
}