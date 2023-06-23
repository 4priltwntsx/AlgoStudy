package boj;

import java.util.*;
import java.io.*;

public class BOJ_2839_설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 0;
		while(true) {
			if(N%5==0) {
				result += N/5;
				System.out.println(result);
				break;
			}
			else {
				N-=3;
				result++;
			}
			if(N<0) {
				System.out.println(-1);
				break;
			}
		}
	}
}
