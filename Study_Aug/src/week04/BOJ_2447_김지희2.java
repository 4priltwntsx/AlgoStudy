package week04;

import java.util.Scanner;
//별찍기
public class BOJ_2447_김지희2 {
	static char[][] stars;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int N = sc.nextInt();
		stars = new char[N][N];
		StringBuilder sb = new StringBuilder();
		
		print_stars(N, 0, 0);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(stars[i][j]!='*') sb.append(' ');
				else {
					sb.append(stars[i][j]);	
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void print_stars(int n, int x, int y) {
		if(n==1) {
			stars[x][y] = '*';
			return;
		}
		
		int n3 = n/3;
		int n32 = 2*n3;
		
		print_stars(n3, x, y);
		print_stars(n3, x+n3, y);
		print_stars(n3, x+n32, y);
		
		print_stars(n3, x, y+n3);
		
		print_stars(n3, x+n32, y+n3);
		
		print_stars(n3, x, y+n32);
		print_stars(n3, x+n3, y+n32);
		print_stars(n3, x+n32, y+n32);
		
	}
	
	
}
