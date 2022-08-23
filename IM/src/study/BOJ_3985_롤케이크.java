package study;

import java.util.Scanner;

public class BOJ_3985_롤케이크 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt(); // 롤케이크의 길이
		int N = sc.nextInt(); // 방청객의 수 
		int[] cake = new int[L+1];
		int number = 1;
		int expect = Integer.MIN_VALUE;
		int result = Integer.MIN_VALUE;
		int answer1 = 0;
		int answer2 = 0;
		
		for(int i= 0; i<N; i++) {
			int P = sc.nextInt();
			int K = sc.nextInt();
			if(expect<(K-P+1)) {
				expect = K-P+1;
				answer1 = i+1;
			}
			int sum=0;
			for(int j=P; j<=K; j++) {
				if(cake[j] == 0) {
					cake[j] = i+1;
					sum++;
				}
			}
			
			if(result<sum) {
				result = sum;
				answer2 =i+1;
			}
		}
		
		System.out.println(answer1);
		System.out.println(answer2);
		
		

	}
}
