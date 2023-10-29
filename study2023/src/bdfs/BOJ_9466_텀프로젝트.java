package bdfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9466_텀프로젝트 {
	static boolean[] visit, done;
	static int N, arr[], count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[N + 1];
			count = 0;
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			visit = new boolean[N + 1];
			done = new boolean[N + 1];
			for (int i = 1; i <= N; i++) {
				if(done[i]) continue;
				dfs(arr[i]);
			}
			System.out.println(N-count);
		}
	}

	public static void dfs(int idx) {
		if(done[idx]) {
			return;
		}
		if(visit[idx]) { // 이미 방문한 노드
			// 사이클 안에 들어왔다.
			done[idx] = true;
			count++;
		}
		
		visit[idx] = true;
		dfs(arr[idx]);
		visit[idx] = false;
		done[idx] = true;
	}
}
