package 아자아자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4012_요리사 {
	static int N, answer;
	static int[][] graph;
	static int[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			
			graph = new int[N][N];
			visit = new int[N];
			answer = Integer.MAX_VALUE;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			comb(0, 0);
			
			System.out.println("#"+tc+" " +answer);
			
		}
		

	}
	
	private static void comb(int idx, int cnt) {
		if(cnt == N/2) {
			int A=0, B=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visit[i]==1 && visit[j]==1) {
						A+=graph[i][j];
					}
					else if(visit[i]==0 && visit[j]==0) {
						B+=graph[i][j];
					}
				}
			}
			
			int res = Math.abs(A-B);
			if(res<answer) answer = res;
		}
		
		
		for(int i=idx; i<N; i++) {
			visit[i] = 1;
			comb(i+1, cnt+1);
			visit[i] = 0;
		}
	}
}
