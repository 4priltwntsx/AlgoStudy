package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1238_파티 {
	
	static class Node implements Comparable<Node>{
		int vertex, cost;
		
		Node(int vertex, int cost){
			this.vertex = vertex;
			this.cost = cost;
		}
		
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}
	
	static int N, M, X;
	static List<Node>[] list, backlist;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		backlist = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<>(); // x마을에서 N번의 마을로...시작점 X
			backlist[i] = new ArrayList<>(); // X마을로 향하는 최단 경로를 구하기 위한 list
		} // init
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to, cost));
			backlist[to].add(new Node(from, cost));
		}
		
		int[] go = dijkstra(list, X);
		int[] back = dijkstra(backlist, X);
		
		int res = Integer.MIN_VALUE;
		for(int i=1; i<N+1; i++) {
			int dis = go[i] + back[i];
			
			if(dis>res) res = dis;
		}
		System.out.print(res);
	}
	static int[] dijkstra(List<Node>[] list, int start) {
		Queue<Node> Q = new PriorityQueue<>();
		boolean[] visit = new boolean[N+1];
		int[] dp = new int[N+1];
		Arrays.fill(dp,Integer.MAX_VALUE);
		
		Q.add(new Node(start, 0));
		dp[start] = 0;
		
		while(!Q.isEmpty()) {
			Node cur = Q.poll();
			int to = cur.vertex;
			if(visit[to]) continue;
			for(Node next : list[to]) {
				if(dp[to] + next.cost < dp[next.vertex]) {
					dp[next.vertex] = dp[to] + next.cost;
					Q.add(new Node(next.vertex, dp[next.vertex]));
				}
			}
		}
		return dp;
	}
}
