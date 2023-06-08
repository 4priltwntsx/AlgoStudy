package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18352_특정거리의도시찾기 {
	
	static int N, M, K, X;

	static class City implements Comparable<City> {
		int vertex, cost;

		City(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}

		public int compareTo(City o) {
			return this.cost - o.cost;
		}
	}

	static ArrayList<City>[] list;
	static int dist[];
	private static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		dist = new int[N+1]; // 거리 저장
		Arrays.fill(dist, INF);
		list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list[x].add(new City(y, 1));
		}
		dijkstra(X);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N+1; i++) {
			if(dist[i]==K) {
				sb.append(i).append("\n");
			}
		}
		if(sb.length()==0) System.out.print(-1);
		else System.out.print(sb.toString());
	}
	
	public static void dijkstra(int x) {
		PriorityQueue<City> Q = new PriorityQueue<>();
		boolean[] visit = new boolean[N+1];
		dist[x] = 0;
		Q.add(new City(x, 0));
		
		while(!Q.isEmpty()) {
			City city = Q.poll();
			int num = city.vertex;
			if(visit[num]) continue;
			
			for(City c : list[num]) {
				if(!visit[c.vertex] && dist[c.vertex]>c.cost+dist[num]) {
					dist[c.vertex] = c.cost + dist[num];
					Q.offer(new City(c.vertex, dist[c.vertex]));
				}
			}
		}
	}
}
