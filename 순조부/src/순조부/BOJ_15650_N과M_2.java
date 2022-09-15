package 순조부;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650_N과M_2 {
	static int N, M;
	static int[] answer, visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		answer = new int[M];
		visit = new int[N+1];
		dfs(0, 1);
		
	}
	
	private static void dfs(int cnt, int idx) {
		if(cnt==M) {
			for(int i=0; i<cnt; i++) {
				System.out.print(answer[i]+" ");
			}System.out.println();
			return;
		}
		
		for(int i=idx; i<=N; i++) {
			
			answer[cnt] = i;
			dfs(cnt+1, i+1);
		}
	}
}
