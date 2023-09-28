package bdfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2583_영역구하기 {
	static class Point {
		int i, j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static int[] di = { 1, -1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static int[][] map, visit;
	static int N, M, K, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new int[N][M];
		ArrayList<Integer> list = new ArrayList<>();
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int si = Integer.parseInt(st.nextToken());
			int sj = Integer.parseInt(st.nextToken());
			int ei = Integer.parseInt(st.nextToken());
			int ej = Integer.parseInt(st.nextToken());

			for (int i = si; i < ei; i++) {
				for (int j = sj; j < ej; j++) {
					map[i][j] = 1;
				}
			}
		} // input end
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0 && visit[i][j]==0) {
					answer = 0;
					dfs(i, j);
					list.add(answer);
				}
			}
		}
		System.out.println(list.size());
		StringBuilder sb = new StringBuilder();
		Collections.sort(list);
		for(int l : list) {
			sb.append(l + " ");
		}
		System.out.print(sb.toString());
	}

	public static void dfs(int nowi, int nowj) {
		visit[nowi][nowj] = 1;
		answer++;
		for (int d = 0; d < 4; d++) {
			int ni = nowi + di[d];
			int nj = nowj + dj[d];
			if(ni<0 || nj<0 || ni>=N || nj>=M) continue;
			if(visit[ni][nj] == 1) continue;
			if(map[ni][nj]==1) continue;
			dfs(ni, nj);
		}
		 
	}
}
