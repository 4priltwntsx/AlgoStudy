package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107_리모컨 {
	static int N; // 이동하려는 채널
	static int M; // 고장난 버튼의 개수
	static boolean[] brokens; // 고장난 버튼의 배열
	static int result;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		brokens = new boolean[10]; 
		// 1. 고장난 버튼이 있다면
		if (M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 고장이 난거면 true로 바꿔줌
			for (int i = 0; i < M; i++) {
				brokens[Integer.parseInt(st.nextToken())] = true;
			}
		}

		// 2. 100번 채널이 목표인 경우
		if (N == 100) {
			System.out.print(0);
			return;
		}
		result = Integer.MAX_VALUE;
		// 3. +, -로만 이동하기
		int cnt = Math.abs(100 - N);
		result = result > cnt ? cnt : result;

		// 4. 모든 경우 버튼 누르기
		dfs(0, "");
		System.out.print(result);
	}

	public static void dfs(int idx, String click) {
		if(idx>6) return;
		for (int i = 0; i < 10; i++) {
			if (brokens[i])
				continue;
			String cur_click = click + Integer.toString(i);
			int cnt = Math.abs(N - Integer.parseInt(cur_click)) + cur_click.length();
			result = result > cnt ? cnt : result;
			dfs(idx+1, cur_click);
		}
	}
}
