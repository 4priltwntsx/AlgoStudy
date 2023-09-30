package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815_숫자카드 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			sb.append(binarySearch(arr, Integer.parseInt(st.nextToken()))).append(" ");
			
		}
		System.out.println(sb.toString());

	}

	public static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		
		while(left<=right) {
			int mid = (left + right)/2;
			
			if(target > arr[mid]) {
				left = mid + 1;
			}
			else if(target<arr[mid]) {
				right = mid - 1;
			}else {
				return 1;
			}
		}return 0;
	}
}
