package decimal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1747_소수앤팰린드롬 {
	
	static boolean prime[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		prime = new boolean[10000001];
		prime[0] = prime[1] = true;
		sieve();
		for(int i=N; i<10000001; i++) {
			if(!prime[i]) {
				if(isPalindrome(i)) {
					System.out.print(i);
					break;
				}
			}
		}
	}
	
	public static void sieve() {
		for(int i=2; i*i<10000001;i++) {
			if(!prime[i]) {
				for(int j=i*i;j<10000001; j+=i) {
					prime[j] = true;
				}
			}
		}
	}
	
	public static boolean isPalindrome(int num) {
		String str = Integer.toString(num);
		char[] arr = str.toCharArray();
		int start = 0, end =arr.length-1;
		
		while(start<end) {
			if(arr[start]!=arr[end]) {
				return false;
			}
			start++;
			end--;
		}
		
		return true;
	}
}
