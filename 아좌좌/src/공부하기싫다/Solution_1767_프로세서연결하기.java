package 공부하기싫다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기 {
	static class Point{
		int i, j;
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	
	static int N, size, answer;
	static int[][] map;
	static ArrayList<Point> coreList;
	static int[] select, check;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			coreList = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						coreList.add(new Point(i, j));
					}
				}
			}
			answer = Integer.MAX_VALUE;
			select = new int[coreList.size()];
			check = new int[coreList.size()];
			size = coreList.size();
			for(int i=size; i>=0; i--) {
				comb(0, 0, i);
				if(answer!=Integer.MAX_VALUE) break;
			}
			
			System.out.println("#"+tc+" "+answer);
			
		}
	}
	
	private static void comb(int idx, int cnt, int M) {
		if(cnt==M) {
			dfs(0, 0);
			return;
		}
		
		for(int i=idx; i<size; i++) {
			check[i] = 1;
			comb(i+1, cnt+1, M);
			check[i] = 0;
		}
	}
	
	private static void dfs(int idx, int cnt) {
		if(idx==size) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		if(check[idx] == 0) {
			dfs(idx+1, cnt);
			return;
		}
		
		
		int[][] copy = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0 ;j<N; j++) {
				copy[i][j] = map[i][j];
			}
		}
				
		Point cur = coreList.get(idx);
		

		for(int d=0 ;d<4; d++) {
			int ni = cur.i;
			int nj = cur.j;
			int tmp = 0;
			boolean flag = false;
			while(true) {
				ni+=di[d];
				nj+=dj[d];
				
				if(ni<0 || nj<0 || ni>=N || nj>=N) { //끝에 도착 -> 성공
					flag = true;
					break;
				}
				if(map[ni][nj] != 0) break;
				map[ni][nj] = 2;
				tmp++;
			}
			if(flag)
				dfs(idx+1, cnt+tmp);
			
			for(int i=0; i<N; i++) {
				for(int j=0 ;j<N; j++) {
					map[i][j] = copy[i][j];
				}
			}
		}
	}
	
}
