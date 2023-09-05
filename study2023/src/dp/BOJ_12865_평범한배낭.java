package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] weight = new int[N+1];
		int[] profit = new int[N+1];                                                       
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			weight[i] = w;
			profit[i] = p;
		}
		int[][] dp = new int[N+1][K+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				if(weight[i]>j) {
					dp[i][j] = dp[i-1][j];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + profit[i]);
				}
			}
		}
		System.out.print(dp[N][K]);
	}
}
