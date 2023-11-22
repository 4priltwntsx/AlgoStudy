import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] dp = new long[101];
		dp[1] = 1L;
		dp[2] = 1L;
		dp[3] = 1L;
		for(int i=4; i<=100; i++) {
			dp[i] = dp[i-2]+dp[i-3];
		}
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=TC; tc++) {
			int now = Integer.parseInt(br.readLine());
			sb.append(dp[now]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}