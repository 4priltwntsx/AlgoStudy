package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arrA = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrA);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int target = Integer.parseInt(st.nextToken());
			System.out.println(binarySearch(arrA, target));
		}
		
	}
	
	public static int binarySearch(int[] arr, int target) {
		
		int left = 0;
		int right = arr.length-1;
		
		while(left<=right) {
			
			int mid = (left+right)/2;
			
			if(target < arr[mid]) {
				right = mid-1;
			}else if(target>arr[mid]) {
				left = mid+1;
			}else {
				return 1;
			}
		}
		
		return 0;
	}
}
