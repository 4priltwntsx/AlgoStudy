package decimal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2581_소수 {
	static boolean prime[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		prime = new boolean[N + 1];
		prime[0] = prime[1] = true;
		sieve(N);
		StringBuilder sb = new StringBuilder();
		int sum = 0;
		int minimum = Integer.MAX_VALUE;
		for (int i = M; i <= N; i++) {
			if (!prime[i]) {
				if (minimum > i)
					minimum = i;
				sum += i;
			}
		}

		if (sum == 0)
			System.out.print(-1);
		else {
			System.out.print(sum + "\n" + minimum);
		}

	}

	public static void sieve(int N) {
		for (int i = 2; i < N + 1; i++) {
			for (int j = i * i; j < N + 1; j += i) {
				prime[j] = true;
			}
		}
	}
}
