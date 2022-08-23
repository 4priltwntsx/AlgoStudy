package study;

import java.util.Scanner;

public class BOJ_2851_슈퍼마리오 {

	static int[] mushrooms;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		mushrooms = new int[10];
		int answer = 0;
		for(int i=0; i<10; i++) {
			mushrooms[i] = sc.nextInt();
		}
		
		for(int i=0; i<10; i++) {
			sum+=mushrooms[i];
			
			int before = Math.abs(100-answer);
			int now = Math.abs(100-sum);
			if(before>=now) answer = sum;
		}
		System.out.println(answer);
	}
}
