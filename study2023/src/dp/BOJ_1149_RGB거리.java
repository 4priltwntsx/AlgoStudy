package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int info[][] = new int[N][3];
		int dp[][] = new int[N][3];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
			info[i][2] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][0] = info[0][0];
		dp[0][1] = info[0][1];
		dp[0][2] = info[0][2];
		
		for(int i=1; i<N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + info[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + info[i][1];
			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + info[i][2];
		}
		
		int answer = Math.min(Math.min(dp[N-1][1], dp[N-1][2]), dp[N-1][0]);
		System.out.println(answer);
	}
}
