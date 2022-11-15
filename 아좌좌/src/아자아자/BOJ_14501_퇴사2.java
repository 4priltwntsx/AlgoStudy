package 아자아자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사2 {
	static int N, answer;
	static int[] arrT, arrP;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arrT = new int[N + 1];
		arrP = new int[N + 1];
		arrT[0] = 0;
		arrP[0] = 0;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arrT[i] = Integer.parseInt(st.nextToken());
			arrP[i] = Integer.parseInt(st.nextToken());
		}

		answer = Integer.MIN_VALUE;
		dfs(1, 0);
		System.out.println(answer);
	}

	private static void dfs(int days, int profit) {
		if (days == N+1) {
			answer = Math.max(answer, profit);
			return;
		}

		if (days + arrT[days] <= N+1) {
			dfs(days + arrT[days], profit + arrP[days]);
		}
		dfs(days + 1, profit);
	}
}
