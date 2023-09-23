package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18500_미네랄2 {
	static class Point implements Comparable<Point> {
		int i, j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			if (this.i == o.i)
				return o.j - this.j;
			return o.i - this.i;
		}
	}

	static int[] di = { 1, -1, 0, 0 };
	static int[] dj = { 0, 0, 1, -1 };
	static int R, C;
	static char[][] map;
	static int N, arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = R - Integer.parseInt(st.nextToken());
		}
		// input end

		for (int i = 0; i < N; i++) {
			int dir = i % 2;
			stick_throw(arr[i], dir);
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			if(i==R-1) break;
			System.out.println();
		}

	}

	// 미네랄 파괴
	public static void stick_throw(int height, int dir) {
		if (dir == 0) { // 왼쪽이면
			for (int j = 0; j < C; j++) {
				if (map[height][j] == 'x') {
					// 미네랄을 만나면
					map[height][j] = '.';
					bfs();
					return;
				}
			}
		} else { // 오른쪽이면
			for (int j = C - 1; j >= 0; j--) {
				if (map[height][j] == 'x') {
					// 미네랄을 만나면
					map[height][j] = '.';
					bfs();
					return;
				}
			}
		}
	}

	// 클러스터 탐색 - 클러스터 구역 정하기
	public static void bfs() {
		// 1~n까지 클러스터 구역 탐색
		int[][] visit = new int[R][C];
		int cluster_idx = 0;
		ArrayList<ArrayList<Point>> cluster = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'x' && visit[i][j] == 0) {
					cluster_idx++;
					Queue<Point> Q = new LinkedList<>();
					Q.add(new Point(i, j));
					visit[i][j] = cluster_idx;
					ArrayList<Point> tmp = new ArrayList<>();
					tmp.add(new Point(i, j));
					while (!Q.isEmpty()) {
						Point cur = Q.poll();

						for (int d = 0; d < 4; d++) {
							int ni = cur.i + di[d];
							int nj = cur.j + dj[d];

							if (ni < 0 || nj < 0 || ni >= R || nj >= C)
								continue;
							if (visit[ni][nj] != 0)
								continue;
							if(map[ni][nj]!='x') continue;
							
							visit[ni][nj] = cluster_idx;
							tmp.add(new Point(ni, nj));
							Q.add(new Point(ni, nj));
						}
					}
					Collections.sort(tmp);
					cluster.add(tmp);
				}
			}
		}
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(visit[i][j]);
//			}
//			System.out.println();
//		}
		// cluster_idx : 클러스터 개수

		// 바닥에 붙어 있는 클러스터를 제외하고, 중력작용
		for (int i = 1; i <= cluster_idx; i++) {
			ArrayList<Point> list = cluster.get(i - 1); // 현재 클러스터 탐색
			if (list.get(0).i == R - 1)
				continue;

			// 현재 클러스터(list)가 바닥이나 다른 클러스터까지 얼마나 내려가는지 확인
			int dist = 1;
			while (true) {
				// 내 현재 cluster_idx랑 visit에 있는 cluster_idx랑 다르면 다른 클러스터
				boolean bottom = false;
				for (Point cur : list) {
					int ni = cur.i + dist;
					if (ni >= R) { // 이해가 잘 안 되는 부분...ㅠㅠ
						bottom = true;
						break;
					}
					if (map[ni][cur.j] == 'x' && visit[ni][cur.j] != i) {
						bottom = true;
						break;
					}
					// 바닥이나 클러스터를 못 만났으면 더 내려간다.
				}
				if (bottom) {
					dist--;
					break;
				}
				dist++;
			}

			for(Point cur : list) {
				map[cur.i][cur.j]= '.';
				map[cur.i+dist][cur.j] = 'x';
			}
		}
	}

	public static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}