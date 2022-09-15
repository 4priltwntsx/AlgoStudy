package 순조부;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649_N과M_1 {
	
	static int N, M;
	static int[] answer, visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		answer = new int[M];
		visit = new int[N+1];
		dfs(0);
		
		
	}
	private static void dfs( int cnt) {
		if(cnt == M) {
			for(int i=0; i<cnt; i++) {
				System.out.print(answer[i]+ " ");
			}System.out.println();
			return;
		}
		for(int i=1; i<=N; i++) {
			if(visit[i] == 1) continue;
			
			visit[i] = 1;
			answer[cnt] = i;
			dfs(cnt+1);
			visit[i] = 0;
		}
	}
}
