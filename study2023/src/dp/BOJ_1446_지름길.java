package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1446_지름길 {
	static class Load{
		int start, end, cost;
		Load(int start, int end, int cost){
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		Load map[] = new Load[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
//			if(to-from<=distance) continue; // 지름길이 아님
//			if(to>D) continue; // 가려는 곳보다 먼 곳.
			map[i] = new Load(from, to, distance);
		}
		
		int[] dp = new int[D+1];
		for(int i=0; i<=D; i++) {
			dp[i] = i; // dp배열 초기화
		}
		
		for(int i=1; i<=D; i++) {
			dp[i] = Math.min(dp[i],  dp[i-1] + 1);
			for(int j=0; j<N; j++) {
				if(map[j].end==i) { // i에 도착하는 지름길을 가지고 있다면
					dp[i] = Math.min(dp[i], dp[map[j].start]+map[j].cost);
				}
			}
		}

		System.out.print(dp[D]);
	}
	
}
