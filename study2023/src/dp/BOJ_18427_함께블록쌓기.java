package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_18427_함께블록쌓기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] blocks = new ArrayList[N+1];
		for(int i=0 ;i<=N; i++) {
			blocks[i] = new ArrayList<>();
			if(i==0) continue;
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				blocks[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int[][] dp = new int[N+1][H+1];
		
		dp[0][0] = 1;
		
		for(int i=1; i<=N; i++) {
			dp[i][0] = 1;
			
			for(int j=1; j<=H; j++) {
				for(int k=0; k<blocks[i].size(); k++) {
					
				}
			}
		}
		
	}
}
