package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2960_에라토스테네스의체 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int count = 0;
		int answer = 0;
		boolean[] check = new boolean[N+1];
		check[0] = check[1] = true; // true -> 지움

		loop: for(int i = 2; i<=N; i++) {
			// i가 소수라면 그의 배수를 지워줌.
			if(!check[i]) {
				// 배수를 지우기
				for(int j=i;j<=N; j+=i) {
					if(!check[j]) count++; 
					check[j] = true;
					
					if(count==K) {
						answer = j;
						break loop;
					}
				}
			}
		}
		System.out.println(answer);
	}
}
