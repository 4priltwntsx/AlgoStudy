package bdfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1707_이분그래프 {
	static int K, V, E;
	static ArrayList<Integer>[] graph;
	static boolean flag;
	static int colors[];
	static final int RED = 1;
	static final int BLUE = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		while (K-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			graph = new ArrayList[V + 1];
			for (int i = 0; i <= V; i++) {
				graph[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				graph[u].add(v);
				graph[v].add(u);
			}
			flag = true;
			colors = new int[V+1];
			for(int i=1; i<=V; i++) {
				if(colors[i]==0) {
					dfs(i, RED);
				}
				if(!flag) break;
			}
			if(flag) System.out.println("YES");
			else System.out.println("NO");
		}

	}

	public static void dfs(int vertex, int color) {
		colors[vertex] = color;
//		if(!flag) return;
		
		for(int v : graph[vertex]) {
			if(colors[v]==colors[vertex]) {
				flag = false;
				return;
			}else if(colors[v]==0) {
				colors[v] = - color;
				dfs(v, -color);
			}
		}
	}
}
