package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053_가장긴증가하는부분수열 {
	static int dp[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int[] arr = new int[A+1];
		dp = new int[A+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=A; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = arr[1];
		int longest = 1;
		for(int i=2; i<=A; i++) {
			if(arr[i]>dp[longest]) {
				dp[longest+1] = arr[i];
				longest++; // dp의 마지막 인덱스
			}
			
			int pos = binarySearch(0, longest, arr[i]);
			dp[pos] = arr[i];
		}
		System.out.println(longest);
	}
	
	public static int binarySearch(int left, int right, int target) {
		int mid = 0;
		while(left<right) {
			mid = (left+right) / 2;
			if(dp[mid] < target) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}
		return right;
	}
}
