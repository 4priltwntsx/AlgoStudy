package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2632_피자판매 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int target = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[] arrA = new int[A*2-2];
		int[] arrB = new int[B*2-2];
		ArrayList<Integer> pizzaA = new ArrayList<>();
		ArrayList<Integer> pizzaB = new ArrayList<>();
		pizzaA.add(0);
		pizzaB.add(0);
		int temp =0;
		for(int i=0; i<A; i++) {
			if((i+A)>=(A*2-2)) arrA[i] = Integer.parseInt(br.readLine());
			else arrA[i] = arrA[i+A] = Integer.parseInt(br.readLine());
			temp+=arrA[i];
		}
		pizzaA.add(temp);
		temp = 0;
		for(int i=0; i<B; i++) {
			if((i+B)>=(B*2-2)) arrB[i] = Integer.parseInt(br.readLine());
			else arrB[i] = arrB[i+B] = Integer.parseInt(br.readLine());
			temp+=arrB[i];
		}
		pizzaB.add(temp);
		
		for(int lt=0; lt<A; lt++) {
			int sum = 0;
			for(int i=0; i<A-1; i++) {
				if(lt+i>A*2-2) break;
				sum += arrA[lt+i];
				if(sum>target) break;
				pizzaA.add(sum);
			}
		}
		for(int lt=0; lt<B; lt++) {
			int sum = 0;
			for(int i=0; i<B-1; i++) {
				if(lt+i>B*2-2) break;
				sum += arrB[lt+i];
				if(sum>target) break;
				pizzaB.add(sum);
			}
		}
		Collections.sort(pizzaA);
		Collections.sort(pizzaB);
		int answer = 0;
		for(int sumA : pizzaA) {
			for(int sumB : pizzaB) {
				if(sumA+sumB==target) answer++;
			}
		}
		System.out.print(answer);
	}
	
}
