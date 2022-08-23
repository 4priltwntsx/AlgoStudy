package week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11286_김지희 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer> priorityQ = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1)==Math.abs(o2)) {
					return o1-o2;
				}else {
					return (Math.abs(o1)-(Math.abs(o2)));
				}
			}
			
			
		});
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp!=0) {
				priorityQ.add(temp);
			}
			else {
				if(priorityQ.isEmpty()) {
					System.out.println(0);
					continue;
				}
				System.out.println(priorityQ.poll());
			}
		}
		
	}
}