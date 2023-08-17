package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16928_뱀과사다리게임 {

	static class Token implements Comparable<Token>{
		int num;
		int cnt;
		Token(int num, int cnt){
			this.num = num;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Token o) {
			// TODO Auto-generated method stub
			return this.cnt-o.cnt;
		}
		
	}
	static int N, M;
	static int[] map;
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[101];
		for(int t=0; t<N+M; t++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			map[i] = j;
		}
		answer = Integer.MAX_VALUE;
		bfs();
		System.out.print(answer);
	}
	
	public static void bfs() {
		PriorityQueue<Token> pQ =  new PriorityQueue<>();
		pQ.add(new Token(1, 0));
		int[] visit = new int[101];
		
		while(!pQ.isEmpty()) {
			Token cur = pQ.poll();
			if(cur.num==100) {
				answer = cur.cnt;
				return;
			}
			for(int d=1; d<=6; d++) {
				int next = cur.num+d;
				
				if(next>100) continue;
				if(visit[next]!=0) continue;
				
				if(map[next]!=0) {
					visit[map[next]] = visit[cur.num]+ 1;
					pQ.add(new Token(map[next], cur.cnt+1));
					continue;
				}
				visit[next] = visit[cur.num] + 1;
				pQ.add(new Token(next, cur.cnt+1));
			}
		}
	}
}
