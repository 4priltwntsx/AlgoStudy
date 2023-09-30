package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class BOJ_2750_수정렬하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[10001];
		for(int i=0; i<N; i++) {
			int idx = Integer.parseInt(br.readLine());
			arr[idx]++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<10001;i++) {
			while(arr[i]-->0) sb.append(i).append("\n");
		}
		System.out.println(sb.toString());
	}
}
