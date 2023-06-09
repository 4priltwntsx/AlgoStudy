package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1446_지름길 {
	
	static class Load implements Comparable<Load>{
		int vertex, distance;
		Load(int vertex, int distance){
			this.vertex = vertex;
			this.distance = distance;
		}
		public int compareTo(Load o) {
			return this.distance-o.distance;
		}
	}
	
	static int N, D; // N: 지름길 개수, D : 고속도로 길이
	static ArrayList<Load>[] list;
	static int[] dist;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[D+1];
		dist = new int[D+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i=0; i<D+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			if(a>D || b>D) continue; // D를 넘어가는 위치는 skip
			if(b-a<=distance) continue; // 직선 거리보다 긴 지름길은 skip
			list[a].add(new Load(b, distance));
		}
		dijkstra();
	}
	
	public static void dijkstra() {
		PriorityQueue<Load> pQ = new PriorityQueue<>();
		pQ.add(new Load(0, 0));
		boolean[] visit = new boolean[D+1];
		
		while(!pQ.isEmpty()) {
		}
	}
}
