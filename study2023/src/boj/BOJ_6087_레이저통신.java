package boj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6087_레이저통신 {
	static class Point {
		int i, j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static int H, W, visit[][];
	static char[][] map;
	static int[] di = { 1, -1, 0, 0 };
	static int[] dj = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int si = 0, sj = 0, gi = 0, gj = 0;
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		visit = new int[H][W];
		int temp = 0;
		for (int i = 0; i < H; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 'C') {
					if (temp == 0) {
						si = i;
						sj = j;
						temp++;
					} else {
						gi = i;
						gj = j;
					}
				}
			}
		}

		bfs(si, sj, gi, gj);
//		for(int i=0; i<H; i++) {
//			for(int j=0; j<W; j++) {
//				System.out.print(visit[i][j]);
//			}
//			System.out.println();
//		}
		System.out.print(visit[gi][gj]-2);
	}

	public static void bfs(int si, int sj, int gi, int gj) {
		Queue<Point> Q = new LinkedList<>();
		Q.add(new Point(si, sj));
		visit[si][sj] = 1;

		while (!Q.isEmpty()) {
			Point cur = Q.poll();
			if(cur.i==gi && cur.j==gj) return;
			for (int d = 0; d < 4; d++) {
				int ni = cur.i + di[d];
				int nj = cur.j + dj[d];
				while (ni >= 0 && nj >= 0 && ni < H && nj < W && map[ni][nj] != '*') {
					if (visit[ni][nj] != 0) {
						ni += di[d];
						nj += dj[d];
						continue;
					}
					visit[ni][nj] = visit[cur.i][cur.j] + 1;
					Q.add(new Point(ni, nj));
					ni += di[d];
					nj += dj[d];
				}
			}
		}
	}
}
