package 공부하기싫다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {
	static int N, answer;
	static int[] arrT, arrP, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arrT = new int[N + 1];
		arrP = new int[N + 1];
		dp = new int[N+1];
		arrT[0] = 0;
		arrP[0] = 0;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arrT[i] = Integer.parseInt(st.nextToken());
			arrP[i] = Integer.parseInt(st.nextToken());
			
			dp[i] = arrP[i];
		}

		answer = Integer.MIN_VALUE;
//		dfs(1, 0);
		dp();
		System.out.println(answer);
	}

	private static void dfs(int days, int profit) {
		if (days == N+1) {
			answer = Math.max(answer, profit);
			return;
		}

		if (days + arrT[days] <= N+1) {
			dfs(days + arrT[days], profit + arrP[days]);
		}
		dfs(days + 1, profit);
	}
	
	private static void dp() {
		for(int i=2; i<=N; i++) {
			for(int j=1; j<i; j++) {
				if(i-j == arrT[j]) {
					dp[i] = Math.max(arrP[i]+dp[j], dp[i]);
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(i+arrT[i]<=N+1) {
				if(answer<dp[i]) {
					answer = dp[i];
				}
			}
		}
	}
	
	private static void dp2() {
		for(int i=N; i>=0; i--) {
			int next = i + arrT[i]; 
			if(next>N+1) continue;
			
			int m = 0;
			for(int j=next; j<N+1; j++) {
				m = Math.max(dp[j], m);
			}
			dp[i] = arrP[i] + m;
		}
		for(int i=0; i<N+1; i++) {
			answer = Math.max(dp[i], answer);
		}
	}
}
