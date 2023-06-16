package boj;

import java.util.*;
import java.io.*;

public class BOJ_14889_스타트와링크 {
	static int N, capability[][];
	static int[] team;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		capability = new int[N + 1][N + 1];
		team = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				capability[i][j] = Integer.parseInt(st.nextToken());
			}
		} // input end

		answer = Integer.MAX_VALUE;
		dfs(0, 1);
		System.out.println(answer);
	}

	public static void dfs(int cnt, int idx) {
		if (cnt == N / 2) {
			int sumStart = 0;
			int sumLink = 0;
			for (int j = 1; j < N; j++) {
				for (int k = j + 1; k <= N; k++) {
					if (team[j] == 1 && team[k] == 1) {
						sumStart += capability[j][k];
						sumStart += capability[k][j];
					}
					if (team[j] == 0 && team[k] == 0) {
						sumLink += capability[j][k];
						sumLink += capability[k][j];
					}
				}
			}
			int sub = Math.abs(sumStart - sumLink);
			if (sub <= answer)
				answer = sub;
			return;
		}
		if (answer == 0)
			System.out.println(0);

		for (int i = idx; i <= N; i++) { // team Start의 조합 구하기
			team[i] = 1;
			dfs(cnt + 1, idx + 1);
			team[i] = 0;
		}
	}
}
