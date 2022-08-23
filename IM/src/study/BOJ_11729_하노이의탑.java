package study;

import java.util.Scanner;

public class BOJ_11729_하노이의탑 {
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//장대에 쌓인 원판의 개수 
//		System.out.println((int)Math.pow(2, N)-1);
		sb = new StringBuilder();
		sb.append(((int)Math.pow(2, N)-1)+"\n");
		recursion(N, 1,2,3);
		System.out.println(sb);
		
	}
	
	private static void recursion(int n, int start, int temp, int end) {
		if(n==1) {
//			System.out.println(start+" "+end);
			sb.append(start+" "+end+"\n");
			return;
		}
		if(n==0) return;
		
		recursion(n-1, start, end, temp);
//		System.out.println(start+" "+end);
		sb.append(start+" "+end+"\n");
		recursion(n-1, temp, start, end);
	}
}
