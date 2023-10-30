import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point {
		int f;
		int i, j;

		Point(int f, int i, int j) {
			this.f = f;
			this.i = i;
			this.j = j;
		}
	}

	static int L, R, C;
	static char[][][] map;
	static int[][][] visit;
	static Point start, end;
	static int[] di = { 1, -1, 0, 0, 0, 0 };
	static int[] dj = { 0, 0, 1, -1, 0, 0 };
	static int[] df = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(L==0 && R==0 && C == 0) {
				System.out.println(sb.toString());
				break;
			}
			map = new char[L][R][C];
			visit = new int[L][R][C];

			for (int f = 0; f < L; f++) {
				for (int i = 0; i < R; i++) {
					map[f][i] = br.readLine().toCharArray();
					for (int j = 0; j < C; j++) {
						if (map[f][i][j] == 'S') {
							start = new Point(f, i, j);
						}
						if (map[f][i][j] == 'E') {
							end = new Point(f, i, j);
						}
					}
				}
				br.readLine();
			}

			int res = bfs(start);
			if (res == Integer.MAX_VALUE)
				sb.append("Trapped!").append("\n");
			else
				sb.append("Escaped in ").append(res-1).append(" minute(s).\n");
		}
	}

	public static int bfs(Point start) {
		Queue<Point> Q = new LinkedList<>();
		Q.add(start);
		visit[start.f][start.i][start.j] = 1;
		int result = Integer.MAX_VALUE;
		while (!Q.isEmpty()) {
			Point cur = Q.poll();
			if (map[cur.f][cur.i][cur.j] == 'E') {
				result = visit[cur.f][cur.i][cur.j];
				break;
			}
			for (int d = 0; d < 6; d++) {
				int ni = cur.i + di[d];
				int nj = cur.j + dj[d];
				int nf = cur.f + df[d];

				if (ni < 0 || nj < 0 || nf < 0 || ni >= R || nj >= C || nf >= L)
					continue;
				if (map[nf][ni][nj] == '#')
					continue;
				if (visit[nf][ni][nj] > 0)
					continue;

				Q.add(new Point(nf, ni, nj));
				visit[nf][ni][nj] = visit[cur.f][cur.i][cur.j] + 1;

			}
		}
		return result;
	}
}