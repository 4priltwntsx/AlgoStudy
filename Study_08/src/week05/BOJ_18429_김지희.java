package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//근손실
public class BOJ_18429_김지희 {
	
	static int N, K;
	static int[] arr, visit;
	static int[] select;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visit = new int[N];
		select = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		answer = 0;
		dfs(500, 0);
		System.out.println(answer);
		
	}
	
	static void dfs(int weight, int day) {
		if(N == day) {
			answer++;
			return;
		}
		
		
		for(int i=0; i<N; i++) {
			if(visit[i]==0) {
				visit[i] = 1;
				select[day] = arr[i];
				int nw = weight-K+select[day];
				if(nw>=500) {
					dfs(nw, day+1);	
				}
				visit[i]=0;
			}
		}
	}
}
