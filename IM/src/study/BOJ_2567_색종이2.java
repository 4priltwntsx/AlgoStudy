package study;

import java.util.Scanner;

public class BOJ_2567_색종이2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] board = new int[101][101];
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		int N = sc.nextInt();
		
		for(int k=0; k<N; k++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			for(int i=x; i<x+10; i++) {
				for(int j=y; j<y+10; j++) {
					board[i][j] = 1;
				}
			}
		}
		int result = 0;
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				if(board[i][j] == 1) {
					for(int d=0; d<4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if(board[nx][ny]==0 || nx<0 || nx>100 || ny<0 || ny>100) {
							result++;
						}
					}
				}
			}
		}
		System.out.println(result);
		
	}
}
