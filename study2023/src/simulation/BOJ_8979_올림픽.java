package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_8979_올림픽 {
	static class Info implements Comparable<Info>{
		int number;
		int gold, silver, bronze;
		Info(int number, int gold, int silver, int bronze){
			this.number = number;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}
		@Override
		public int compareTo(Info o) {
			if(this.gold==o.gold) {
				if(this.silver==o.silver) {
					return o.bronze-this.bronze;
				}
				return o.silver-this.silver;
			}
			return o.gold-this.gold;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		PriorityQueue<Info> Q = new PriorityQueue<>();
		for(int n=1; n<=N; n++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			Q.add(new Info(num, g, s, b));
		}
		
		Info preInfo = Q.poll();
		int rank = 1;
		if(preInfo.number==K) {
			System.out.println(1);
			System.exit(0);
		}
		int same = 0;
		while(!Q.isEmpty()) {
			Info cur = Q.poll();
			if(!(cur.gold==preInfo.gold && cur.silver==preInfo.silver && cur.bronze==preInfo.bronze)) {
				preInfo = cur;
				rank++;
				if(same>0) {
					rank += same;
					same = 0;
				}
			}else {
				same++;
			}
			if(preInfo.number==K) break;
		}
		
		System.out.print(rank);
	}
}
