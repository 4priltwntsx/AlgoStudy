package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719_빗물 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] height = new int[W];
		st = new StringTokenizer(br.readLine());
		for(int i=0 ;i<W; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		for(int i=1; i<W; i++) {
			int left = 0;
			int right = 0;
			
			for(int j=0; j<i; j++) {
				if(left<height[j]) left = height[j];
			}
			for(int j=i+1; j<W; j++) {
				if(right<height[j]) right = height[j];
			}
			
			int min = Math.min(left, right);
			if(min==0) continue;
			if(left<height[i] || right<height[i]) continue;
			answer += (min-height[i]);
		}
		System.out.print(answer);
	}
}
