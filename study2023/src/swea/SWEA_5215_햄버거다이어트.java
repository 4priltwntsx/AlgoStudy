package swea;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_5215_햄버거다이어트 {
	static int answer;
	static int[] calories, scores;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			answer = 0;
			calories = new int[N];
			scores = new int[N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				scores[i] = Integer.parseInt(st.nextToken());
				calories[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0, 0, N, L);
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(answer);
			System.out.println(sb.toString());
		} // test case end
	}
 
	public static void dfs(int idx, int sumCal, int sumSco, int N, int L) {
		if(sumCal>L) return; // 제한 칼로리를 넘는다면
		if(idx==N) {
			if(sumSco>answer) answer = sumSco; // 최대 점수 계산
			return;
		}
		
		dfs(idx+1, sumCal+calories[idx], sumSco+scores[idx], N, L); // 현재 재료를 먹는다면
		dfs(idx+1, sumCal, sumSco, N, L); // 안 먹는다면
	}
}
