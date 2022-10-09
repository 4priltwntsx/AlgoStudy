package 공부하기싫다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1949_등산로조성 {

	static class Point {
		int i, j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static int N, K, answer;
	static int[][] map;
	static int[][] visit;
	static ArrayList<Point> maxList;
	static int[] di = { 1, -1, 0, 0 };
	static int[] dj = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visit = new int[N][N];

			int max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (max < map[i][j]) {
						max = map[i][j];
					}
				}
			}
			answer = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max) {
						visit[i][j] = 1;
						dfs(i, j,true, 1); // 땅 안 깎았으면 true
						visit[i][j] = 0;
					}
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}

	private static void dfs(int nowi, int nowj, boolean cutCheck, int cnt) {
		if(answer<cnt) answer = cnt;

		for(int d=0; d<4; d++) {
			int ni = nowi + di[d];
			int nj = nowj + dj[d];
			
			if(ni<0 || nj<0 || ni>=N || nj>=N) continue;
			if(visit[ni][nj] == 1) continue;
			
			if(map[ni][nj] < map[nowi][nowj] && visit[ni][nj] == 0) { // 갈 수 있는 조건일 때
				visit[ni][nj] = 1;
				dfs(ni, nj, cutCheck, cnt+1);
				visit[ni][nj] = 0;
			}
			else if(map[ni][nj] >= map[nowi][nowj]) { // 못 가는 조건일 떄
				if(cutCheck) { // 지형 변경이 안 되어 있으면
					for(int c=1; c<=K; c++) {
						if(map[ni][nj]-c < map[nowi][nowj] && map[ni][nj]-c>=0) {
							map[ni][nj]-=c;
							visit[ni][nj] = 1;
							dfs(ni, nj, false, cnt+1);
							visit[ni][nj] = 0;
							map[ni][nj]+=c;
						}
					}
				}
			}
		}
	}
}
