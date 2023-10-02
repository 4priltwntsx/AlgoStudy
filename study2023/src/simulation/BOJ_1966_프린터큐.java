package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1966_프린터큐 {
	static class Paper implements Comparable<Paper>{
		int idx, prp;
		Paper(int idx, int prp){
			this.idx = idx;
			this.prp = prp;
		}
		public int compareTo(Paper o) {
			return o.prp - this.prp;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int target = 0;
			st = new StringTokenizer(br.readLine());
			
			PriorityQueue<Paper> Q = new PriorityQueue<>();
			
			for(int i=0; i<N; i++) {
				int temp = Integer.parseInt(st.nextToken());
				if(i==M) target = temp;
				Q.add(new Paper(i, temp));
			}
			int answer = 0;
			int idx = 1;
			while(!Q.isEmpty()) {
				Paper cur = Q.poll();
				if(cur.idx==M) answer = idx;
				idx++;
			}
			System.out.println(answer);
		}
	}
}
