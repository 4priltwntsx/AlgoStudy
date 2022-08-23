package week04;

import java.util.Scanner;
//별찍기
public class BOJ_2447_김지희 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				print_stars(N, i, j);
			}
			System.out.println();
		}
	}

	private static void print_stars(int n, int i, int j) {
		//n은 3^k, (x, y) = (0,0);
		
	
		
		if((i/n)%3 == 1 && (j/n)%3 == 1) {
			System.out.print(" ");
			return;
		}
		else {
			if(n/3==0) System.out.print("*");
			else print_stars(n/3, i, j);
		}
		
	}
	
	
}
