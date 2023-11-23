package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_10431_줄세우기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int turn = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[20];
			for(int i=0; i<20; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int answer = check(arr);
			
			sb.append(tc).append(" ").append(answer+"\n");
			
		}
		
		System.out.println(sb.toString());
	}
	
	public static int check(int[] arr) {
		int cnt=0;
		for(int i=0 ;i<20; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i]<arr[j]) cnt++;
			}
		}
		return cnt;
	}
}
