package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13549_숨바꼭질3 {
	
	static class Point implements Comparable<Point>{
		int index, time;
		Point(int index, int time){
			this.index = index;
			this.time = time;
		}
		@Override
		public int compareTo(Point o) {
			return this.time-o.time;
		}
	}
	
	static int N, K;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[100001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[N] = 0; // 시작점
		
		PriorityQueue<Point> pQ = new PriorityQueue<>();
		pQ.add(new Point(N, 0)); // 시작점
		
		while(!pQ.isEmpty()) {
			Point cur = pQ.poll();
			int index = cur.index;
			int time = cur.time;
			
			if(index*2 <=100000 && dp[index*2] > time) {
				dp[index*2] = time;
				pQ.add(new Point(index*2, time));
			}
			if(index-1>=0 && dp[index-1]>time+1) {
				dp[index-1] = time+1;
				pQ.add(new Point(index-1, time+1));
			}
			if(index+1<=100000 && dp[index+1]>time+1) {
				dp[index+1] = time;
				pQ.add(new Point(index+1, time+1));
			}
		}
		System.out.println(dp[K]);
	}
}
