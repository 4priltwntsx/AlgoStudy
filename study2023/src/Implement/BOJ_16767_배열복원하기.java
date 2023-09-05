package Implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16767_배열복원하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		int[][] arrB = new int[H+X][W+Y];
		int[][] arrA = new int[H][W];
		
		int height_B = H+X;
		int width_B = W+Y;
		
		for(int i=0; i<height_B; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<width_B; j++) {
				arrB[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 겹쳐지지 않는 부분
		for(int i=0; i<X; i++) {
			for(int j=0; j<W; j++) {
				arrA[i][j] = arrB[i][j];
			}
		}
		for(int i=X; i<H; i++) {
			for(int j=0; j<Y; j++) {
				arrA[i][j] = arrB[i][j];
			}
		}
		
		// arrA[i][j] = arrB[i][j] - arrA[i-X][j-Y];
		// i-X>=0 -> i>=X -> i는 X부터 H(arrA의 높이)의 범위
		for(int i=X; i<H; i++) {
			for(int j=Y; j<W; j++) {
				arrA[i][j] = arrB[i][j] - arrA[i-X][j-Y];
			}
		}
		
		print(arrA, H, W);
	}
	
	public static void print(int[][] arr, int H, int W) {
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				System.out.print(arr[i][j]+ " ");
			}System.out.println();
		}
	}
}
