package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_Maze {
	static int N, M;
	static int[][] map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		for(int i=0; i<N; i++) {
			String[] str = br.readLine().split("");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		} //input end
		
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				System.out.print(map[i][j]);
//			}System.out.println();
//		} //input check
		
		bfs();
		System.out.println(map[N-1][M-1]);
	}
	
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	private static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private static void bfs() {
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(0,0));
		map[0][0] = 1;
		Point temp;
		
		while(!Q.isEmpty()) {
			temp = Q.poll();
//			print();
//			System.out.println();
			
			for(int i=0; i<4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				
				if(0<=nx && nx <N && 0<=ny && ny<M && map[nx][ny] == 1) {
					Q.offer(new Point(nx, ny));
					map[nx][ny] = map[temp.x][temp.y] +1;
				}
			}
			
		}
		
		
	}
	
}
