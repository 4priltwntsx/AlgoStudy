package 심심풀이;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1747_소수팰린드롬 {
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		ArrayList<Integer> answer = new ArrayList<>();
		
		for(int i=N; i<=Integer.MAX_VALUE; i++) {
			if(i==1) continue; //1은 소수가 아님
			
			StringBuilder sb = new StringBuilder();
			sb.append(i);
			String input = sb.toString();
			String output = sb.reverse().toString();
			if(output.equals(input)) {
				if(isPrime(i)) {
					System.out.println(i);
					System.exit(0);
				}
			}
		}
		
	}
	
	private static boolean isPrime(int num) {
		for(int i=2; i<num; i++) {
			if(num%i==0) return false;
		}
		return true;
	}
}
