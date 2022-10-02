package 공부하기싫다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_보급로 {
	
	static class Node implements Comparable<Node>{
		int x, y;
		int cost;
		
		Node(int x, int y, int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}
	
	static int N;
	static int[][] map, dis;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());

		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			dis = new int[N][N];
			for(int i=0; i<N; i++) {
				String[] str = br.readLine().split("");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}
			for(int i=0; i<N; i++) {
				Arrays.fill(dis[i], Integer.MAX_VALUE);
			}
			
			bfs();
			
			System.out.println("#"+ tc + ": "+ dis[N-1][N-1]);
			
		}
		
	}
	
	
	private static void bfs() {
		dis[0][0] = map[0][0];
		
		PriorityQueue<Node> pQ = new PriorityQueue<>();
		
		pQ.add(new Node(0,0, map[0][0]));
		
		while(!pQ.isEmpty()) {
			Node cur = pQ.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<N) { //범위 확인
					if(dis[nx][ny] > dis[cur.x][cur.y] + map[nx][ny]) {
						dis[nx][ny] = dis[cur.x][cur.y] + map[nx][ny];
						pQ.add(new Node(nx, ny, dis[nx][ny]));
					
					}
				}
			}
		}
	}
	
}
