package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1931_김지희 {
	
	static class Time implements Comparable<Time>{
		 int start;
		 int end;
		
		Time(int s, int e){
			this.start = s;
			this.end = e;
		}

		@Override
		public int compareTo(Time o) {
			
			/*o1 > o2 이면 1
			 * o1 < o2 이면 -1
			 * o1 = o2 이면 0 
			 * */
			
			if(this.end==o.end) {
				return this.start-o.start;
			}
			else {
				return this.end-o.end;
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Time> arr = new ArrayList<>();
		
		for(int n=0; n<N; n++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			arr.add(new Time(s,e));
		}
		//input end
		
		Collections.sort(arr);
		// 1. 끝나는 시간으로 정렬하기
		// 2. 끝나는 시간이 같을 경우 시작 시간으로 정렬하기
		
		//끝나는 시간이 빠른 순으로 회의를 시작하면 
		// 최대 사용할 수 있는 회의의 최대 개수를 알 수 있다,,,
		int e = 0;
		int s = 0;
		int answer=0;
		for(Time t : arr) {
			//0,0부터 시작한다고 가정
			if(t.start<e) {
				continue;
			}else { //t.start>=e
				answer++;
				s=t.start;
				e=t.end;
			}
		}
		
		System.out.println(answer);
		
		
		
	}
}
