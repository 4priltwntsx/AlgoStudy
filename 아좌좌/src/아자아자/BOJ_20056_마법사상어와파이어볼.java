package 아자아자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20056_마법사상어와파이어볼 {
	static class FireBall {
		int r, c, m, d, s;

		public FireBall(int r, int c, int m, int d, int s) {
			this.r = r;
			this.c = c;
			this.m = m; // 질량
			this.d = d; // 방향
			this.s = s; // 속력
		}
	}

	static int N, M, K;
	static int[] di = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dj = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static ArrayList<FireBall> map[][];
	static ArrayList<FireBall> fireList;
	static Queue<FireBall> Q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		fireList = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

//			map[r][c].add(new FireBall(r, c, m, d, s));
			fireList.add(new FireBall(r, c, m, d, s));
//			Q.add(new FireBall(r, c, m, d, s));

		}

		for (int k = 0; k < K; k++) {
			// 1. 파이어볼 이동
			move();
			
			// 2. 두개 이상이면 merge
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(map[i][j].size()>=2)
						merge(i, j);
				}
			}
			fireList = new ArrayList<>();
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(map[i][j].size()>0) {
						for(FireBall f : map[i][j])
							fireList.add(f);
					}
				}
			}
		}
		
		int answer = 0;
		for(FireBall f : fireList) {
			answer+= f.m;
		}
		
		System.out.println(answer);
	}

	private static void move() {
		map = new ArrayList[N+1][N+1];
		for(int i=0; i<=N; i++) {
			for(int j=0; j<=N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		for(FireBall cur : fireList) {
			int spd = cur.s;
			
			cur.r = cur.r + di[cur.d]*(cur.s%N);
			cur.c = cur.c + dj[cur.d]*(cur.s%N);
			
			if(cur.r > N) cur.r%=N;
			if(cur.c > N) cur.c%=N;
			if (cur.r <= 0) cur.r = N + cur.r;
			if (cur.c <= 0) cur.c = N + cur.c;
			
			map[cur.r][cur.c].add(cur); 
		}
	}

	private static void merge(int i, int j) {
		int cnt = map[i][j].size();
		int sumM=0, sumS=0;
		
		boolean odd=true, even=true;
		
		for(FireBall cur : map[i][j]) {
			sumM += cur.m;
			sumS += cur.s;
			
			if(cur.d % 2 == 0) odd = false;
			else even = false;
		}
		
		int M = sumM/5;
		int S = sumS/cnt;
		
		map[i][j] = new ArrayList<>(); //초기화
		
		if(M<=0) return;
		
		if(odd || even) { //모두 홀이거나 짝일 떄
			for(int d=0; d<4; d++) {
				map[i][j].add(new FireBall(i, j, M, d*2, S));
			}
		}
		else {
			 // 아니면
			for(int d=0; d<4; d++) {
				map[i][j].add(new FireBall(i, j, M, d*2+1, S));
			}
		
		}
	}
}
