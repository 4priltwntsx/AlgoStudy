package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014_스타트링크 {
	static int F, S, G, U, D;
	static int[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken()); // 총 건물의 층
		S = Integer.parseInt(st.nextToken()); // 시작 층
		G = Integer.parseInt(st.nextToken()); // 목표 층
		U = Integer.parseInt(st.nextToken()); // 위로 이동 가능한 층
		D = Integer.parseInt(st.nextToken());
		visit = new int[F + 1];
		bfs(S);
	}

	private static void bfs(int start) {
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(start);
		visit[start] = 1; // 방문체크

		while (!Q.isEmpty()) {
			int cur = Q.poll();

			if (cur == G) {
				System.out.println(visit[cur]-1);
			}
			if (cur + U <= F && visit[cur + U] == 0) { // 제한범위 안에 있고, 방문 안 했으면
				visit[cur+U] = visit[cur] + 1;
				Q.add(cur+U);
			}
			if(cur-D>0 && visit[cur-D]==0) {
				visit[cur-D] = visit[cur] +1;
				Q.add(cur-D);
			}
		}
		if(visit[G]==0) {
			System.out.println("use the stairs");
		}
	}

}
