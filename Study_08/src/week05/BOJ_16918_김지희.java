package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//봄버맨
public class BOJ_16918_김지희 {
	static int R, C, N;
	static char[][] map;
	static int[][] times;
	static int[][] visit;
	
	static Queue<Point> Q;
	static int[] dx = {1,0,-1,0}, dy= {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken()); //N초가 흐른 후 격자판 상태 
		
		map = new char[R][C];

		Q = new LinkedList<>();
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int n = 2; n<=N; n++) { //1초는 아무것도 안하니까
			//2초부터 N초까지 반복문
			//짝수 초에 폭탄 설치, 홀수 초에 bomb
			if(n%2!=0) {
				for(int i=0; i<R; i++) {
					for(int j=0; j<C; j++) {
						if(map[i][j] == 'O')
							Q.add(new Point(i, j));
					}
				}
				//그 다음 초에 어차피 또 채우니까 여기서 먼저 채우고
				for(int i=0; i<R; i++) {
					for(int j=0; j<C;j++) {
						map[i][j] = 'O';
					}
				}
				
				bfs();
			}
		}
		if(N%2==0) {
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					map[i][j] = 'O';
				}
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
	
	private static void bfs() {
		while(!Q.isEmpty()) {
			Point cur = Q.poll();
			int x = cur.x;
			int y = cur.y;
			map[x][y] = '.';
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && ny>=0 && nx<R && ny<C) {
					if(map[nx][ny] == 'O')
						map[nx][ny] = '.';
				}
			}
		}
	}
	
	


	static class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
