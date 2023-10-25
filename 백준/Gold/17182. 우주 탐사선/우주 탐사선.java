import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Edge {
		int vertex, cost;

		Edge(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}
	}

	static int N, K, map[][], answer;
	static boolean visit[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // start

		map = new int[N][N];
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // input end

		// start(K)부터 모든 행성 탐사하는데 걸리는 최소 시간 계산
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i==j) continue;
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		answer = Integer.MAX_VALUE;
		visit[K] = true;
		dfs(K, 0, 0);
		System.out.print(answer);
	}

	public static void dfs(int start, int idx, int sum) {
		if (idx == N - 1) {
			answer = Math.min(answer, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				dfs(i, idx + 1, sum + map[start][i]);
				visit[i] = false;
			}
		}
	}
}