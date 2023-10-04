package bdfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14940_쉬운최단거리 {
	static class Point {
		int i, j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static int[] di = { 0, 0, 1, -1 };
	static int[] dj = { 1, -1, 0, 0 };
	static int[][] map, dist;
	static int N, M;
	static Point start;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dist = new int[N][M];
		for(int i=0; i<N; i++) {
			Arrays.fill(dist[i], -1);
		}
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					start = new Point(i, j);
				}
			}
		}
		
		bfs();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(dist[i][j]==-1 && map[i][j] !=1) sb.append(0).append(" ");
				else sb.append(dist[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	public static void bfs() {
		Queue<Point> Q = new LinkedList<>();
		Q.add(start);
		dist[start.i][start.j]=0;
		
		while(!Q.isEmpty()) {
			Point cur = Q.poll();
			
			for(int d=0; d<4; d++) {
				int ni = cur.i + di[d];
				int nj = cur.j + dj[d];
				
				if(ni<0 || nj<0 || ni>=N || nj>=M) continue;
				if(dist[ni][nj] != -1) continue;
				if(map[ni][nj] == 0) continue;

				dist[ni][nj] = dist[cur.i][cur.j]+1;
				Q.add(new Point(ni, nj));
			}
		}
	}
}
