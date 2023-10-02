package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1138_한줄로서기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = N - 1; i >= 0; i--) {
			list.add(arr[i],i+1);
		}
		StringBuilder sb = new StringBuilder();
		for(int i : list) {
			sb.append(i).append(" ");
		}
		System.out.println(sb.toString());
	}
}
