package boj;
import java.util.*;
import java.io.*;

public class BOJ_3109_빵집 {
	static class Point{
		int i, j;
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	static int[] di = {-1,0,1};
	static int[] dj = {1,1,1}; 
	static int answer;
	static boolean flag, visit[][];
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];

		for(int r=0; r<R; r++) {
			map[r] = br.readLine().toCharArray();
		}
		answer = 0;
		
		for(int i=0; i<R; i++) {
			flag = false;
			dfs(i, 0, R,C);
		}
		System.out.print(answer);
	}
	
	private static void dfs(int i, int j, int R, int C) {
		if(j==C-1) { // 마지막 열에 도착했으면
			answer++;
			flag = true;
			return;
		}
		
		for(int d=0; d<3; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			
			if(ni<0||nj<0||ni>=R||nj>=C) continue;
			if(visit[ni][nj] || map[ni][nj]!='.') continue;
			
			visit[ni][nj]=true;
			map[ni][nj] = '-';
			dfs(ni, nj, R,C);
			if(flag) return;
		}
		
	}

}
