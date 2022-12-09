package week03;

import java.util.Scanner;

public class BOJ_16922_김지희 {
	static int N;
	static int[] sums;
	static int[] nums = {1,5,10,50};
	static int[] visit;
	static int answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		visit = new int[1001];
		answer =0;
		dfs(0, 0, 0);
		System.out.println(answer);
		
	}
	
	//중복조합
	private static void dfs(int cnt, int idx, int s) {
		if(cnt == N) {
			if(visit[s] == 0) {
				visit[s] = 1;
				answer++;
			}
			return;
		}
		for(int i= idx; i<4; i++) {
			dfs(cnt+1, i, s+ nums[i]);
		}
	}
}
