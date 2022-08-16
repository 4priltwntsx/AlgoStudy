package week2;

import java.util.Scanner;

public class BOJ_1213_Palindrome {


	static int[] alphabet;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		String s = sc.next();
		alphabet = new int[26];
		
		for(int i=0; i<s.length(); i++) {
			int n = s.charAt(i) - 'A';
			alphabet[n]++;
//			System.out.println(alphabet[n]);
		}
		
		int mid =0;
		int oddcnt = 0;
		for(int i=0; i<26; i++) {
			if(alphabet[i]%2 ==1) { 
				mid = i;
				oddcnt++;
			}
		}
		
		
		if((s.length()%2!=0 && oddcnt>1) || (s.length()%2==0 && oddcnt>1)) {
			sb.append("I'm sorry Hansoo");
		}
		
		else {
			String front = "";
			for(int i=0; i<26; i++) {
				for(int j=0; j<alphabet[i]/2; j++) {
					front += (char)(i+'A');
				}
			}
			String back = new StringBuilder(front).reverse().toString();
			
			if(oddcnt==1) front += (char)(mid+'A');
			
			sb.append(front).append(back);

		}
		System.out.println(sb);
		
		
		System.out.println();
	} 
	

}
