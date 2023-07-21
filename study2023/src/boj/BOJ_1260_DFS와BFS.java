package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
	static int N, M, V;
	static int[][] map;
	static int[] visit;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		map = new int[N+1][N+1];
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			map[i][j] = 1;
			map[j][i] = 1;
		}
		
		sb = new StringBuilder();
		visit = new int[N+1];
		dfs(V);
		sb.append("\n");
		visit = new int[N+1];
		bfs(V);
		System.out.print(sb.toString());
	}
	
	private static void dfs(int vertex) {
		visit[vertex] = 1;
		sb.append(vertex).append(" ");
		if(vertex==N+1) {
			return;
		}
		for(int i=1; i<N+1; i++) {
			if(map[vertex][i]==1 && visit[i]==0) {
				visit[i] = 1;
				dfs(i);
			}
		}
	}
	
	private static void bfs(int vertex) {
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(vertex);
		visit[vertex] = 1;
		sb.append(vertex).append(" ");
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			for(int i=1; i<N+1; i++) {
				if(map[cur][i]==1 && visit[i]==0) {
					visit[i] = 1;
					Q.add(i);
					sb.append(i).append(" ");
				}
			}
		}
	}
}
