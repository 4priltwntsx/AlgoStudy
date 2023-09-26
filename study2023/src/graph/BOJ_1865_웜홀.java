package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1865_웜홀 {
	static class Edge {
		int vertex, weight;

		Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}

	static int N, M, W; // 지점, 도로, 웜홀
	static ArrayList<Edge>[] graph;
	static long[] dist;
	static final int INF = 987654321;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			graph = new ArrayList[N + 1];
			dist = new long[N + 1];

			for (int i = 0; i <= N; i++) {
				graph[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				graph[s].add(new Edge(e, t));
				graph[e].add(new Edge(s, t));
			}
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				graph[s].add(new Edge(e, t * (-1)));
			}
			boolean cycle = false;
			sb.append(bellman(1)?"YES\n" : "NO\n");
		}
		System.out.println(sb.toString());
	}

	public static boolean bellman(int start) {
		Arrays.fill(dist, INF);
		dist[start] = 0;
		boolean flag = false;

		for (int i = 1; i < N; i++) { // 정점의 개수 -1번 최단 거리 초기화 작업 반복
			// 최단 거리 초기화
			for (int j = 1; j <= N; j++) {
				for (Edge edge : graph[j]) {
					if (dist[edge.vertex] > dist[j] + edge.weight) {
						dist[edge.vertex] = dist[j] + edge.weight;
						flag = true;
					}
				}
			}
			if (!flag)
				break; // 값이 변하지 않았다
		}

		if (flag) { // N번째에 또 값이 변한다 확인
			for (int i = 1; i <= N; i++) {
				for (Edge edge : graph[i]) {
					if ( dist[edge.vertex] > dist[i] + edge.weight)
						return true;
				}
			}
		}
		return false;
	}
}
