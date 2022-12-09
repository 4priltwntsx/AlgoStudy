package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17073_나무위의빗물 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		double W = Integer.parseInt(st.nextToken());
		int[] vertex = new int[N+1];
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			vertex[a]++;
			vertex[b]++;
		}
		int leafCnt = 0;
		
		for(int i=2; i<=N; i++) {
			if(vertex[i] == 1) {
				leafCnt++;
			}
		}
		
		System.out.println(W/(double)leafCnt);
	}

}
