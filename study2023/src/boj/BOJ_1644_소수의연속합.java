package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1644_소수의연속합 {
	static boolean[] prime;
	static int N;
	static ArrayList<Integer> prime_list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		prime = new boolean[N+1];
		prime[0] = prime[1] = true;
		prime_list = new ArrayList<>();
		// 1. 소수 구하기
		sieve();
		// 2. 연속합 가능 판별
		int left=0, right=0, sum=0, answer=0;
		while(true) {
			if(sum>=N) { // 현재 합이 목표보다 크거나 같으면,
				sum-= prime_list.get(left++);
			}
			else if(right==prime_list.size()) break; // 인덱스 다 찼으면
			else if(sum<N) {
				sum += prime_list.get(right++);
			}
			
			if(sum==N) answer++;
		}
		System.out.print(answer);
		
	}
	public static void sieve() { // 에라토스테네스의 체
		for(int i=2; i*i<=N; i++) {
			if(!prime[i]) {
				for(int j=i*i; j<=N; j+=i) {
					prime[j] = true;
				}
			}
		}
		for(int i=2; i<=N; i++) {
			if(!prime[i]) prime_list.add(i);
		}
	}
}
