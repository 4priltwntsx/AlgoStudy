package 순조부;

import java.util.Scanner;

public class BOJ_15652_N과M4 {
	
	static int N, M;
	static int[] select, visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		select = new int[M];
		visit = new int[N+1];
		
		perm(0,1);
	}
	
	private static void perm(int cnt, int start) {
		if(cnt==M) {
			for(int i=0; i<M; i++) {
				System.out.print(select[i] + " ");
			}System.out.println();
			return;
		}
		for(int i=start; i<=N; i++) {
			select[cnt] = i;
			perm(cnt+1, i);
		}
	}
}
