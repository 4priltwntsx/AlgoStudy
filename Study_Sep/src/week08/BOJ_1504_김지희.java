package week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 특정한 최단 경로
public class BOJ_1504_김지희 {
	static class Edge implements Comparable<Edge>{
		int next, dis;
		Edge(int next, int dis){
			this.next = next;
			this.dis = dis;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.dis-o.dis;
		}
	}
	
	
	static int N, E;
	static ArrayList<Edge>[] list;
	static int[] dist;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Edge(b, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int vertex1 = Integer.parseInt(st.nextToken());
		int vertex2 = Integer.parseInt(st.nextToken());
		
		dijkstra(1, vertex1, 0);
		dijkstra(vertex1, vertex2, dist[vertex1]);
		dijkstra(vertex2, N, dist[vertex2]);
		
		answer = dist[N];
		
		
		dijkstra(1, vertex2, 0);
		dijkstra(vertex2, vertex1, dist[vertex2]);
		dijkstra(vertex1, N, dist[vertex1]);

		answer = ( answer >= Integer.MAX_VALUE && dist[N] >= Integer.MAX_VALUE) ? -1 : Math.min(answer, dist[N]);
		
		System.out.println(answer);
	}
	
	private static void dijkstra(int start, int end, int d) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		int[] visit = new int[N+1];
		pQ.offer(new Edge(start, d));
		dist[start] = d;
		
		while(!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			
			if(visit[cur.next] == 1) continue;
			visit[cur.next] = 1;
			
			if(cur.dis > dist[cur.next]) continue;			
			for(Edge e : list[cur.next]) {
				if(visit[e.next] == 0 && dist[e.next] >= dist[cur.next] + e.dis) {
					dist[e.next] = dist[cur.next] + e.dis;
					pQ.offer(new Edge(e.next, dist[e.next]));
				}
			}
		}
	}
}
