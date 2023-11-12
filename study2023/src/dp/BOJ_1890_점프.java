package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1890_점프 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N][N];
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int go = map[i][j];
				if(go==0) break;
				if(j+go<N) {
					dp[i][j+go] += dp[i][j];
				}
				if(i+go<N) {
					dp[i+go][j] += dp[i][j];
				}
			}
		}
		
		System.out.println(dp[N-1][N-1]);
	}
}
