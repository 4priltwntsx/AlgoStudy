package dijkstra;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1261_알고스팟 {
	static class Point implements Comparable<Point> {
		int i, j;
		int cnt;
		
		Point(int i, int j, int cnt){
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.cnt - o.cnt;
		}

	}
	static int N, M, visit[][] ;
	static char[][] map;
	static int[] di = {1, -1, 0, 0};
	static int[] dj = {0, 0, 1, -1};
	static int answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new int[N][M];
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		answer = 0;
		bfs();
		System.out.print(answer);
	}
	
	public static void bfs() {
		PriorityQueue<Point> pQ = new PriorityQueue<>();
		pQ.add(new Point(0,0,0));
		visit[0][0] = 1;
		
		while(!pQ.isEmpty()) {
			Point cur = pQ.poll();
			
			if(cur.i==N-1 && cur.j==M-1) {
				answer = cur.cnt;
				return;
			}
			
			for(int d=0; d<4; d++) {
				int ni = cur.i + di[d];
				int nj = cur.j + dj[d];
				
				if(ni<0 || nj<0 || ni>=N || nj>=M)continue;
				if(visit[ni][nj]!=0) continue;
				
				if(map[ni][nj] == '1') {
					visit[ni][nj] = 1;
					pQ.add(new Point(ni, nj, cur.cnt+1));
				}else {
					visit[ni][nj] = 1;
					pQ.add(new Point(ni, nj, cur.cnt));	
				}
			}
			
		}
	}
}