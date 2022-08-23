package study;

import java.util.Scanner;

public class BOJ_3052_나머지 {
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int[] arr = new int[1001];
		for(int i=0; i<10; i++) {
			int index = (sc.nextInt())%42;
			arr[index]++;
		}
		int answer=0;
		for(int i=0; i<1001; i++) {
			if(arr[i]>0) answer++;
		}
		System.out.println(answer);
	}
}
