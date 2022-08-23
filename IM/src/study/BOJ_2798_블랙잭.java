package study;

import java.util.Scanner;

public class BOJ_2798_블랙잭 {
	static int N, M;
	static int[] cards, select;
	static int answer;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		cards = new int[N];
		select = new int[3];
		for(int i=0; i<N; i++) {
			cards[i] = sc.nextInt();
		}
		answer = Integer.MIN_VALUE;
		comb(0, 0);
		System.out.println(answer);
	}
	
	private static void comb(int cnt, int idx) {
		if(cnt==3) {
			int sum =0;
			for(int i=0; i<3; i++) {
				sum+=select[i];
			}
			if(sum>M) return; //M 초과 시
			else {
				answer = Math.max(answer, sum);
				return;
			}
		}
		
		for(int i=idx; i<N; i++) {
			select[cnt] = cards[i];
			comb(cnt+1, i+1);
		}
	}
}
