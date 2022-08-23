package study;

import java.util.Scanner;

public class BOJ_1182_부분수열의합 {
	static int N, S;
	static int[] arr;
	static int answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		answer =0;
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		dfs(0,0);
		System.out.println(answer);
	}
	
	private static void dfs(int cnt, int sum) {
		if(cnt==N) {
			if(sum==S) {
				answer++;
			}
			return;
		}
		
		dfs(cnt+1, sum+arr[cnt]);
		dfs(cnt+1, sum);
	}
}
