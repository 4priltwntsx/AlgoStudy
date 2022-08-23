package study;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11399_ATM {
	static int N;
	static int[] times;
	static int[] select, check;
	static int answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		times = new int[N];
		select = new int[N];
		check = new int[N];
		for(int i=0; i<N; i++) {
			times[i] = sc.nextInt();
		}
		
		Arrays.sort(times);
//		answer =Integer.MAX_VALUE;
		answer = 0;
//		dfs(0);
		for(int i=0; i<N; i++) {
			for(int j=0; j<=i; j++) {
				answer += times[j];
			}
		}
		System.out.println(answer);
		
	}
	
	private static void dfs(int cnt) {
		if(cnt==N) {
			int sum = 0;
			for(int i=0; i<N; i++) {
				sum+=select[i];
				
			}
			answer = Math.min(answer, sum);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(check[i]==0) {
				check[i] = 1;
				select[cnt] += times[i];
				
				if(cnt==0) select[cnt] = times[i];
				else select[cnt] = select[cnt-1] + times[i];
				dfs(cnt+1);
				check[i]=0;
			}
		}
	}
}
