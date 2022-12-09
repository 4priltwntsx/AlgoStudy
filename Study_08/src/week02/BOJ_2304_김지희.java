package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_2304_김지희 {
	
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
		
//		ArrayList<Pillar> arr = new ArrayList<>();
//		HashMap<Integer, Integer> pillar = new HashMap<>();
		Map<Integer, Integer> pillar = new TreeMap<>();
//		ArrayList<HashMap<Integer, Integer>> arr = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			if(maxH<h) {
				maxrow = l;
				maxH = h; //제일 높은 기둥 좌표값 찾아 놓기
			}
			
//			arr.add(new Pillar(l, h));
			pillar.put(l,  h);
			
			
		}
		
		// x축 따라 정렬하기		
//		Collections.sort(arr);
//		Collections.sort(pillar);
		//tree map은 순서 보장

		int cnt=0;
		
		int h = 0;
		for(Integer idx : pillar.keySet()) {
			if(pillar.get(idx)==maxH) {
				cnt++;
			}

		}
		if(cnt>1) {
			int c = cnt/2;
			for(Integer idx : pillar.keySet()) {
				if(idx == maxrow) {
					pillar.put(idx+c, pillar.get(idx+c)+1);
					maxrow+=c;
					maxH++;
					break;
				}
			}
		}
		//MaxH 중복 처리 (높이에 +1 해서 독보적 높이를 만들어줬으니 나중에 -1 해줄 것.)
		
		int stop = 0;
		
		int s =0;
		int y =0;
		int sum=0;
		int i =0;
		for(Integer idx : pillar.keySet()) {
			
			if(i==0) {
				i++;
				s = idx; //맨 처음 시작 x좌표
				y = pillar.get(s); //맨 처음 기둥의 높이
				continue;
			}
			
			if(idx<maxrow) {//maxH의 왼쪽부터 계산
				//이전 높이보다 작으면 넘겨야 하는데
				if(pillar.get(idx)>y) {
					int x = idx-s; //현재 좌표부터 이전 좌표까지의 거리
					sum = sum + (x*y); //이전 좌표의 기둥 높이로 너비 계산
					
					s = idx; // 현재 좌표를 다음 계산에 넘긴다.	
					y = pillar.get(idx);
				}

			}else if(idx==maxrow){ //maxH 기둥 너비 더해주기
				sum += maxH;
				sum--;
				s = idx;
				y=0;
			}else {
				s = idx;
				break; 
			}
			
		}
		
		System.out.println(sum);
		
	}
}
 