package week04;

import java.util.Scanner;
//에라토스테네스의 체
public class BOJ_2960_김지희 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] ch = new int[N+1];
		int cnt=0;
		int answer = 0;
		
		for(int i=2; i<=N;i++) {
			if(ch[i]!=1) {
				for(int j=i; j<=N; j+=i) {
					if(ch[j]!=1) {
						cnt++;
//						System.out.print(j+ " ");
					}
					ch[j] = 1;
					if(cnt==K) {
						System.out.println(j);
						System.exit(0);
					}
				}
			}
		}
		
	}
}
