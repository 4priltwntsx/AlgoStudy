package bdfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4963_섬의개수 {
	static class Point {
		int i, j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static int[] di = { 1, -1, 0, 0, -1, -1, 1, 1 };
	static int[] dj = { 0, 0, 1, -1, -1, 1, -1, 1 };
	static int N, M, answer, map[][], visit[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if(N==0 && M==0) {
				break;
			}
			map = new int[M][N];
			visit = new int[M][N];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			answer = 0;
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]==1 && visit[i][j]==0) {
						dfs(i, j);
						answer++;
					}
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void dfs(int nowi, int nowj) {
		visit[nowi][nowj] = 1;
		
		for(int d=0; d<8; d++) {
			int ni = nowi + di[d];
			int nj = nowj + dj[d];
			
			if(ni<0 || nj<0 || ni>=M || nj>=N) continue;
			
			if(visit[ni][nj]==1) continue;
			if(map[ni][nj]==0) continue;
			
			dfs(ni, nj);
		}
	}
}
