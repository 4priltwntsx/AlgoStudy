package decimal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929_소수구하기 {
	
	static boolean[] prime;
	static int M, N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		prime = new boolean[N+1];
		prime[0] = prime[1] = true;
		sieve();
		for(int i=M; i<=N; i++) {
			if(!prime[i]) {
				System.out.println(i);
			}
		}
	}
	
	public static void sieve() {
		for(int i=2; i*i<=N; i++) {
			if(!prime[i]) {
				for(int j=i*i; j<=N; j+=i) {
					prime[j] = true;
				}
			}
		}
	}
}
