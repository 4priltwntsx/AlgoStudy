package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_11779_최소비용구하기2 {
	static class Bus implements Comparable<Bus>{
		int dest_city, cost, stopover;
		Bus(int dest_city, int cost){
			this.dest_city = dest_city;
			this.cost = cost;
		}
		public int compareTo(Bus o) {
			return this.cost - o.cost;
		}
	}
	
	static int N, M;
	static ArrayList<ArrayList<Bus>> citys;
	static int[] dist;
	static int[] pre_city; // idx번 도시 직전 방문 도시 번호 저장
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		citys = new ArrayList<>();
		dist = new int[N+1];
		pre_city = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			citys.add(new ArrayList<>());
		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		StringTokenizer st;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			citys.get(from).add(new Bus(to, cost));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int dest = Integer.parseInt(st.nextToken());

		dijkstra(start);
		
		StringBuilder sb = new StringBuilder();

		System.out.println(dist[dest]);
		Stack<Integer> stack = new Stack<>();
		int idx = dest;
		int cnt = 1;
		stack.push(dest);
		while(true) {
			if(idx==start) {
				break;
			}
			stack.push(pre_city[idx]);
			idx = pre_city[idx];
			cnt++;
		}
		sb.append(stack.size()).append("\n");
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.print(sb.toString());
		
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Bus> pQ = new PriorityQueue<>();
		pQ.add(new Bus(start, 0));
		dist[start] = 0;
		
		while(!pQ.isEmpty()) {
			Bus cur = pQ.poll();
			int cur_city = cur.dest_city;
			int cost = cur.cost;
			if(dist[cur_city] < cost) continue;
			for(Bus next : citys.get(cur_city)) {
				if(dist[cur_city] + next.cost < dist[next.dest_city]) {
					dist[next.dest_city] = dist[cur_city] + next.cost;
					pQ.add(new Bus(next.dest_city, dist[next.dest_city]));
					pre_city[next.dest_city] = cur_city;
				}
			}
			
		}
		
	}
}
