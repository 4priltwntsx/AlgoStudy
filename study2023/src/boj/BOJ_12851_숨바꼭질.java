package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851_숨바꼭질 {
	static int N, K, visit[];
	static int ans_time, ans_cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visit = new int[100001];
		ans_cnt = 0;
		ans_time = Integer.MAX_VALUE;
		bfs();
		System.out.print(ans_time + "\n" + ans_cnt);
	}

	public static void bfs() {
		Queue<Integer> Q = new LinkedList<>();
		Q.add(N);
		visit[N] = 0;
		int time = 0;
		while (!Q.isEmpty()) {
			int size = Q.size();

			for (int s = 0; s < size; s++) {
				int cur = Q.poll();
				
				if (cur == K) {
					if(ans_time>time && visit[cur]==0) ans_time = time;
					if(time==ans_time) ++ans_cnt;
					continue;
				}
				visit[cur] = 1;
				int next = cur - 1;
				if (next >= 0 && visit[next] == 0) {
					Q.add(next);
				}
				next = cur + 1;
				if ( next <= 100000 && visit[next] == 0) {
					Q.add(next);
				}
				next = cur * 2;
				if (next <= 100000 && visit[next] == 0) {
					Q.add(next);
				}
			}
			time++;
		}
	}
}
