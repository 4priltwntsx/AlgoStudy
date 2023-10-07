package bdfs;

import java.util.Scanner;

public class Dice {

	static int N, select[], answer[];
	static int arr[] = { 0,1, 2, 3, 4, 5, 6 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int c = sc.nextInt();

		select = new int[7];
		answer = new int[N];

		switch (c) {
		case 1:
			// 순열
			perm(0);
			break;
		case 2:
			comb(0, 1);
			break;
		case 3:
//			comb2(0, 1);
			comb3(0,1);
			break;
		case 4:
			subset(1);
			break;
		}

	}

	private static void perm(int cnt) {
		if (cnt == N) { // N개 순열
			// 순열 완성~
			for (int i : answer) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= 6; i++) {
			if (select[i] == 1)
				continue;
			answer[cnt] = i;
			select[i] = 1;
			perm(cnt + 1);
			select[i] = 0;
		}
	}

	private static void comb(int cnt, int start) { //조합 for문
		if (cnt == N) { // N개 조합
			for (int i : answer) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i <= 6; i++) {
			answer[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	private static void comb2(int cnt, int start) { //중복조합
		if (cnt == N) { // N개 조합
			for (int i : answer) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i <= 6; i++) {
			answer[cnt] = i;
			comb2(cnt + 1, i);
		}
	}

	private static void comb3(int cnt, int start) { //조합 재귀
		if(cnt==N) { //N개 조합
			for(int i : answer) {
				System.out.print(i+" ");
			}System.out.println();
			return;
		}
		
		if(start==7) return;
		
		answer[cnt] = arr[start];
		comb3(cnt+1, start+1);
		comb3(cnt, start+1);
		
	}

	private static void subset(int start) {
		if (start == 7) {
			for (int i = 1; i <= 6; i++) {
				if (select[i] == 1) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
			return;
		}

		select[start] = 1;
		subset(start + 1);
		select[start] = 0;
		subset(start + 1);
	}
}