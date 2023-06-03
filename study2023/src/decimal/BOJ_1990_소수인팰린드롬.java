package decimal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1990_소수인팰린드롬 {
	static int A, B;
	static boolean[] prime;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		StringBuilder answer = new StringBuilder();
		prime = new boolean[B + 1];
		prime[0] = prime[1] = true;
		sieve();

		for (int i = A; i <= B; i++) {
			if (!prime[i]) {
				StringBuilder sb = new StringBuilder();
				sb.append(i);
				String input = sb.toString();
				String output = sb.reverse().toString();
				if (output.equals(input)) {
					answer.append(i).append("\n");
				}
			}

		}
		answer.append(-1);
		System.out.print(answer.toString());
	}

	public static boolean isPrime(int num) {
		if (num == 1)
			return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static void sieve() {
		for (int i = 2; i * i <= B; i++) {
			if (!prime[i]) {
				for (int j = i * i; j <= B; j += i) {
					prime[j] = true;
				}
			}
		}
	}
}
