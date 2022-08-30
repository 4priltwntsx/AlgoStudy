import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_2304 {
	
	static class Pillar implements Comparable<Pillar>{
		int leftside;
		int height;
		
		public Pillar(int leftside, int height) {
			this.leftside = leftside;
			this.height = height;
		}

		@Override
		public int compareTo(Pillar o) {
			return this.leftside-o.leftside;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int maxrow=0, maxH=0; //가장 긴 기둥 
		
		ArrayList<Pillar> arr = new ArrayList<>();
//		HashMap<Integer, Integer> pillar = new HashMap<>();
//		Map<Integer, Integer> pillar = new TreeMap<>();
//		ArrayList<HashMap<Integer, Integer>> arr = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			if(maxH<h) {
				maxH = h; //제일 높은 기둥 좌표값 찾아 놓기

			}
			
			arr.add(new Pillar(l, h));
			
//			pillar.put(l,  h);
			
			
		}
		
		// x축 따라 정렬하기		
		Collections.sort(arr);
//		for(int i=0; i<arr.size(); i++) {
//			System.out.println(arr.get(i).height);
//		}
		
		for(int i=0; i<arr.size(); i++) {
			if(arr.get(i).height == maxH) {
				maxrow = i;
				break;
			} // 제일 긴 기둥 찾기
		}
		
		int sum = 0;
		
		//왼쪽 부분 너비 덧셈
		for(int i=0; i<maxrow; i++) {
			for(int j=i+1; j<=maxrow; j++) {
				if(arr.get(i).height <= arr.get(j).height) {
					sum+= (arr.get(j).leftside - arr.get(i).leftside) * arr.get(i).height;
					i = j;
				}
			}
		}
		
		for(int i=N-1; i>maxrow; i--) {
			for(int j=i-1; j>=maxrow; j--) {
				if(arr.get(i).height <= arr.get(j).height) {
					// 왼쪽이 더 클 경우에만
					sum += (arr.get(i).leftside - arr.get(j).leftside) * arr.get(i).height;
					i = j;
				}
			}
		}
		
		sum += maxH; // 마지막에 젤 긴 기둥 더해주기 

		System.out.println(sum);
		
	}
}
 