package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11501_주식 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int maxProfit = arr[N-1];
			long answer = 0;
			for(int i=N-2; i>=0; i--) {
				if(maxProfit>=arr[i]) {
					answer += (maxProfit-arr[i]);
				}else {
					maxProfit = arr[i];
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}