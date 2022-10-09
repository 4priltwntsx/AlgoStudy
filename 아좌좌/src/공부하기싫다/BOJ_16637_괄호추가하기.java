package 공부하기싫다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16637_괄호추가하기 {
	static int N, answer, res;
	static char[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = br.readLine().toCharArray();
		
		answer = Integer.MIN_VALUE;
		res = 0;
		dfs(2, arr[0]-'0');
		System.out.println(answer);
	}

	private static void dfs(int idx, int val) {

		if (idx >= N) {
			answer = Math.max(answer, val);
			return;
		}

		// 괄호 사용X : 이전 값과 현재 값 연산  A + B
		res = cal(val, arr[idx]-'0', arr[idx-1]);
		dfs(idx+2, res);
		// 괄호 사용O : 현재 값과 다음숫자 연산 후 이전 값과 연산 A + (B + C)
		if(idx+2<N) {
			res = cal(arr[idx]-'0', arr[idx+2]-'0', arr[idx+1]);
			int r2 = cal(val, res, arr[idx-1]);
			dfs(idx+4, r2);
		}
	}

	private static int cal(int a, int b, char op) {
		if (op == '+')
			return a + b;
		if (op == '-')
			return a - b;
		return a * b;
	}
}
