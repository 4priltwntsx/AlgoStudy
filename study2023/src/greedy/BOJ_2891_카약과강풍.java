package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2891_카약과강풍 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 2];
		Arrays.fill(arr, 1);
		for (int i = 0; i < S; i++) {
			int idx = Integer.parseInt(st.nextToken());
			arr[idx] -= 1; // 손상되면 -1값
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int idx = Integer.parseInt(st.nextToken());
			arr[idx]+=1; // 손상되었으면 다시 0, 아니면 1
		}
		
		int answer = 0;
		
		for(int i=1; i<=N; i++) {
			if(arr[i]==2) {
				if(i==1) {
					if(arr[i+1]==0) {
						arr[i]=1;
						arr[i+1] = 1;
						continue;
					}
				}else if(i==N) {
					if(arr[i-1]==0) {
						arr[i-1] = 1;
						arr[i] = 1;
						continue;
					}
				}else {
					if(arr[i-1]==0) {
						arr[i-1] = 1;
						arr[i] = 1;
						continue;
					}else if(arr[i+1]==0) {
						arr[i+1] = 1;
						arr[i] = 1;
						continue;
					}
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(arr[i]==0) {
				answer++;
			}
		}
		System.out.println(answer);
	}

}
