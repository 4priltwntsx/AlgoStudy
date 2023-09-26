package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11657_타임머신 {
	static class Bus {
		int dest, cost;

		Bus(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
	}

	static int N, M;
	static long dist[];
	static ArrayList<Bus>[] graph;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		dist = new long[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Bus(b, c));
		}
		if (bellmanFord(1)) {
			System.out.print(-1);
		} else {
			for (int i = 2; i <= N; i++) {
				if(dist[i]==INF) System.out.println(-1);
				else System.out.println(dist[i]);
			}
		}
	}

	public static boolean bellmanFord(int start) {
		Arrays.fill(dist, INF);
		dist[start] = 0;
		boolean flag = false;

		for (int i = 1; i < N; i++) {
			for (int j = 1; j <= N; j++) {
				for (Bus bus : graph[j]) {
//					if(dist[j]==INF) break;
					if (dist[bus.dest] > dist[j] + bus.cost) {
						dist[bus.dest] = dist[j] + bus.cost;
						flag = true;
					}
				}
			}
			if (!flag)
				break;
		}
		if (flag) {
			for (int i = 1; i <= N; i++) {
				for (Bus bus : graph[i]) {
//					if(dist[i] == INF) break;
					if (dist[bus.dest] > dist[i] + bus.cost) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
