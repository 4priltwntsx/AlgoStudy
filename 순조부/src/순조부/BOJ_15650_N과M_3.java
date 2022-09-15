package 순조부;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650_N과M_3 {
	static int N, M;
	static int[] answer, visit;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		answer = new int[M];
		visit = new int[N+1];
		sb = new StringBuilder();
		dfs(0);
		System.out.println(sb);
	}
	
	private static void dfs(int cnt) {
		if(cnt==M) {
			for(int i=0; i<cnt; i++) {
				sb.append(answer[i] + " ");
			}sb.append('\n');
			return;
		}
		
		for(int i=1; i<=N; i++) {
			
			answer[cnt] = i;
			dfs(cnt+1);
		}
	}
}
