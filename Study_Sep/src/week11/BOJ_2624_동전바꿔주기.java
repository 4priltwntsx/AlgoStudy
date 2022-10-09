package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2624_동전바꿔주기 {
	static int T, k, answer;
	static int[][] dp;
	static int[] coinValue, coinNums;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		coinValue = new int[k+1];
		coinNums = new int[k+1];
		coinValue[0] = 0;
		coinNums[0] = 0;
		
		for(int i=1; i<=k; i++) {
			st = new StringTokenizer(br.readLine());
			coinValue[i] = Integer.parseInt(st.nextToken());
			coinNums[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[k+1][T+1];
		dp[0][0] = 1;
		
		answer = 0;
		
		for(int i=1; i<k+1; i++) {
			int cost = coinValue[i];
			for(int j=0; j<=coinNums[i]; j++) {
				for(int t=0; t<=T; t++) {
					int pos = t + cost * j;
					if(pos>T) break;
					dp[i][pos] += dp[i-1][t];
				}
			}
		}
		
		System.out.println(dp[k][T]);
	}
}
