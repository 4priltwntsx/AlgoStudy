package 아자아자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4179_불 {
	static class Point{
		int x, y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int R, C;
	static char[][] map;
	static int[][] visit;
	static Point Jihoon, Fire;
	static Queue<Point> Q, JhQ;
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	/*
	 * #: 벽 
	 * .: 지나갈 수 있는 공간 
	 * J: 지훈이의 미로에서의 초기위치 (지나갈 수 있는 공간) 
	 * F: 불이 난 공간
	 */
	
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visit = new int[R][C];
		Q = new LinkedList<>();

		
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				if(map[i][j] == 'J') {
					Jihoon = new Point(i, j);
					visit[i][j] = 1;
					if(i==0 || j==0 || i==R-1 || j==C-1) {//가장 자리이면
						System.out.println(1);
						System.exit(0);
					}

				}
				if(map[i][j] == 'F') {
					Fire = new Point(i, j);
					Q.add(new Point(i, j));
				}
			}
		}
		// input end;
		
		bfs();
//		System.out.println(answer);
		System.out.println(answer==Integer.MAX_VALUE ? "IMPOSSIBLE" : answer);
		
	}
	
	private static void bfs() {
		JhQ = new LinkedList<>();
		JhQ.add(Jihoon);
		
		while(!JhQ.isEmpty()) {
			int size = Q.size();
			
			for(int s=0; s<size; s++) {
				Point cur = Q.poll();
				
				for(int d=0; d<4; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					
					if(nx<0 || ny<0 || nx>=R || ny>=C) continue;
					
					if(map[nx][ny] == '.') {
						Q.add(new Point(nx, ny));
						map[nx][ny] = 'F';
					}
				}
			}
			
			//지훈이 이동할게
			size = JhQ.size();
			for(int s=0; s<size; s++) {
				Point cur = JhQ.poll();
				
				for(int d=0; d<4; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					
					if(nx<0 || ny<0 || nx>=R || ny>=C) continue;
					
					if(map[nx][ny] == '.' && visit[nx][ny]==0) {
						JhQ.add(new Point(nx, ny));
						visit[nx][ny] = visit[cur.x][cur.y]+1 ;
					}
					if(nx==0 || ny==0 || nx==R-1 || ny==C-1) {//가장 자리이면
						if(map[nx][ny] == '.') {
							visit[nx][ny] = visit[cur.x][cur.y]+1;
							answer = Math.min(answer, visit[nx][ny]);
						}
					}
				}
			}
		}
	}

}
