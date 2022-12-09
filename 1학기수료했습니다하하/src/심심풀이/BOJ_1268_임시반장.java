package 심심풀이;

import java.util.Scanner;

public class BOJ_1268_임시반장 {
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		map = new int[N+1][6];
		for(int i=0; i<N; i++) {
			for(int j=0 ;j<5; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int answer =0, max = 0;
		
		for(int i=0; i<N; i++) {
			int cnt = 0;
			for(int j=0; j<N; j++) {
				for(int k=0; k<5; k++) {
					if(map[i][k] == map[j][k]) {
						cnt++;
						break;
					}
				}
			}
			if(cnt>max) {
				max = cnt; 
				answer = i;
			}
		}
		System.out.println(answer+1);
	}
}
