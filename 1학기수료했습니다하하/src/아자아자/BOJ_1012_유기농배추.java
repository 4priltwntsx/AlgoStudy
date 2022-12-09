package 아자아자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, K, answer;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] map, visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치 개수

			map = new int[M][N];
			visit = new int[M][N];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[x][y] = 1;
			}

			answer = 0;
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1 && visit[i][j] == 0) {
						bfs(i, j);
						answer++;
					}
				}
			}
			
			System.out.println(answer);
		}
	}

	private static void bfs(int x, int y) {
		Queue<Point> Q = new LinkedList<>();
		Q.add(new Point(x,y));
		visit[x][y] = 1;
		
		while(!Q.isEmpty()) {
			Point cur = Q.poll();
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
				if(map[nx][ny] == 1 && visit[nx][ny] == 0) {
					Q.add(new Point(nx, ny));
					visit[nx][ny] = 1;
				}
				
			}
		}
	}

}
