package programmers;

public class Solution_피보나치수 {
	public static int solution(int n) {
		int answer = 0;
		
		int[] arr = new int[n+1];
		
		arr[0] = 0;
		arr[1] = 1;
		for(int i=2; i<=n; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		answer = arr[n]%1234567;
		return answer;
	}
	
	public static int fibonacci(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		
		return fibonacci(n-1) + fibonacci(n-2);
		
	}
	public static void main(String[] args) {
		System.out.println(solution(3));
		System.out.println(solution(5));
	}
}
 