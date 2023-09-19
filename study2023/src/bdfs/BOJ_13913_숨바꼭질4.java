package bdfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_13913_숨바꼭질4 {
	static class Point implements Comparable<Point>{
		int index;
		int cnt;
		Point(int index, int cnt){
			this.index = index;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.cnt-o.cnt;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[100001];
		int[] pre_index = new int[100001];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Point> pQ = new PriorityQueue<>();
		pQ.add(new Point(N, 0));
		dist[N] = 0;
		
		while(!pQ.isEmpty()) {
			Point cur = pQ.poll();
			int nowi = cur.index;
			int cnt = cur.cnt;
			if(nowi*2<100001 && dist[nowi*2]>cnt+1) {
				dist[nowi*2] = cnt+1;
				pre_index[nowi*2] = nowi;
				pQ.add(new Point(nowi*2, cnt+1));
			}
			if(nowi+1 <100001 && dist[nowi+1]>cnt+1) {
				dist[nowi+1] = cnt+1;
				pre_index[nowi+1] = nowi;
				pQ.add(new Point(nowi+1, cnt+1));
			}
			if(nowi-1>=0 && dist[nowi-1] > cnt+1) {
				dist[nowi-1] = cnt+1;
				pre_index[nowi-1] = nowi;
				pQ.add(new Point(nowi-1, cnt+1));
			}
		}
		int idx = K;
		Stack<Integer> stack = new Stack<>();
//		stack.push(idx);
		while(true) {
			if(idx==N) {
				stack.push(N);
				break;
			}
			stack.push(idx);
			idx = pre_index[idx];
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(dist[K]);
		System.out.print(sb.toString());
	}
}
