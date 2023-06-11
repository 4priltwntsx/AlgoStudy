package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16953_AtoB {
	static long A, B;
	static boolean visit[];
	static long answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken()); // target
		answer = 0;
		bfs();
		System.out.println(answer + 1);
	}

	public static void bfs() {
		Queue<Long> Q = new LinkedList<>();
		Q.add(A);

		while (!Q.isEmpty()) {
			int size = Q.size();

			for (int s = 0; s < size; s++) {
				long cur = Q.poll();
				if (cur > B)
					continue;
				if (cur == B)
					return;
				Q.add(cur * 2);
				Q.add(cur * 10 + 1);
			}
			answer++;
		}
		answer = -2;
	}

}
