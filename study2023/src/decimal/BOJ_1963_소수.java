package decimal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1963_소수 {
	static int A, B;
	static int answer;
	static String target;
	static boolean[] prime;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		prime = new boolean[10000];
		prime[0] = prime[1] = true;
		sieve();
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			target = st.nextToken();
			B = Integer.parseInt(target);
			answer = Integer.MAX_VALUE;
			bfs();
			System.out.println(answer);
		}
	}
	public static void bfs() {
		boolean[] visit = new boolean[10000];
		visit[A] = true;
		Queue<Integer> Q = new LinkedList<>();
		Q.add(A);
		int cnt = 0;
		while(!Q.isEmpty()){
			int size = Q.size();
			
			for(int s=0; s<size; s++) {
				int cur = Q.poll();
				
				if(cur==B) {
					answer = answer>cnt ? cnt : answer;
				}
				
				int[] curNums = {cur/1000, (cur%1000)/100, (cur%100)/10,cur%10};
				for(int i=0; i<4; i++) {
					for(int j=0; j<=9; j++) {
						if(i==0 && j==0) continue; // 범위체크
						
						 int temp = curNums[i]; // 현재 자리수의 수 임시저장
						 curNums[i] = j; // 숫자 바꾸기
						 StringBuilder sb = new StringBuilder();
						 for(int k=0; k<4; k++) {
							 sb.append(curNums[k]);
						 }
						 int next = Integer.parseInt(sb.toString());
						 curNums[i] = temp;
						 if(visit[next] || prime[next]) continue;
						 Q.add(next);
						 visit[next] = true;
					}
				}
			}
			cnt++;
		}
		
	}
	
	public static void sieve() {
		for(int i=2; i*i<=9999; i++) {
			if(!prime[i]) {
				for(int j=i*i; j<=9999; j+=i) {
					prime[j] = true;
				}
			}
		}
	}
}
