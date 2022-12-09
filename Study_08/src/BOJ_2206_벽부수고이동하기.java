import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2206_벽부수고이동하기 {
	
	static class Point{
		int x;
		int y;
		int cnt; //이동횟수
		int wall; //벽 부순 여부
		
		public Point(int x, int y, int cnt, int wall) {
			this.x=x;
			this.y = y;
			this.cnt = cnt;
			this.wall = wall; // 벽이면 1, 아니면 0
		}
	}
	
	static int[][] map;
	static int[][][] visited;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static int N;
	static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new int[N][M][2];
		
		for(int i=0; i<N; i++) {
			String[] str = sc.next().split("");
			for(int j=0; j<str.length; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		bfs();
		
		
	}
	
	private static void bfs() {
		Queue<Point> Q = new LinkedList<>();
		
		Q.offer(new Point(0,0,1,0));
		visited[0][0][0] = 1;
		visited[0][0][1] = 1;
		
		while(!Q.isEmpty()) {
			Point cur = Q.poll();
			
			if(cur.x==N-1 && cur.y==M-1) {
				System.out.println(cur.cnt);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M) {
					
					//벽을 만났을 때
					if(map[nx][ny] == 1) {
						//벽을 부순 상태가 아니면 벽을 부수고 방문하기
						if(cur.wall==0 && visited[nx][ny][1]!=1) {
							Q.offer(new Point(nx, ny, cur.cnt+1, 1));
							visited[nx][ny][1] = 1;
						}
					}
					else { // 이동 가능한 길이라면
						if(visited[nx][ny][cur.wall]==0) { //벽을 부쉈는지 아닌지 확인
							Q.offer(new Point(nx, ny, cur.cnt+1, cur.wall));
							visited[nx][ny][cur.wall] = 1;
						}
					}
					
					
				}
			}
		}
		System.out.println(-1);
	}
}
