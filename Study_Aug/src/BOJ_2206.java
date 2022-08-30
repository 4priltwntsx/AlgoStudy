import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2206 {
	
	static int[][] board;
	static int[][] dis;
	static int[][][] visited;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static int N;
	static int M;
	
	
	static class Point{
		int x;
		int y;
		int wall;
		
		public Point(int x, int y, int wall) {
			this.x=x;
			this.y = y;
			this.wall = wall; // 벽이면 1, 아니면 0
		}
	}
	
	
	public void BFS(int x, int y, int wall) {
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(x,y, board[x][y]));

/*
 * 
	visit[x][y][wall]
	visit[x][y][0] : 벽을 부수지 않고 좌표(x, y)를 방문
	visit[x][y][1] : 벽을 부수고 좌표(x, y)를 방문
 * 
 * */
		
		while(!Q.isEmpty()){
			Point tmp = Q.poll();
			int w = tmp.wall;
			for(int i=0; i<4; i++) {
				int nx = tmp.x+dx[i];
				int ny = tmp.y+dy[i];
				
				if(nx>=0 && nx<=N && ny>=0 && ny<=M) {
					// 1. 벽인데 부수지 않았으며 방문 하지 않은 곳.
					if(board[nx][ny]==1 && w==0 && visited[nx][ny][1]==0) {
						visited[nx][ny][1] = 1;
						dis[nx][ny] = dis[tmp.x][tmp.y]+1;
						Q.offer(new Point(nx, ny, board[nx][ny]));
					}
					
					
					// 2. 벽이 아니고 방문하지 않은 곳
					
					
					
					
					// 3. 목적지에 도착한 경우...
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		
	}
}
