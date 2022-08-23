package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563_김지희 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 색종이의 수
		
		int[][] board = new int[101][101];
		
		for(int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int xDis = Integer.parseInt(st.nextToken());
			int yDis = Integer.parseInt(st.nextToken());
			
			for(int i=xDis; i<xDis+10; i++) {
				for(int j=yDis;j<yDis+10; j++) {
					board[i][j] = 1;
				}
			}
		}
		
		int answer = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(board[i][j] == 1) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}