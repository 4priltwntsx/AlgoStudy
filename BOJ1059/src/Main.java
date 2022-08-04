import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		int[] arr = new int[L];
		for(int i=0; i<L; i++) {
			arr[i] = sc.nextInt();
		}
		int n = sc.nextInt();
		
		Arrays.sort(arr);
		int start = 0;
		int end = Integer.MAX_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] < n) {
				if(arr[i]>start) start = arr[i];
			}else if(arr[i]>n) {
				if(arr[i]<end) end = arr[i];
			}else {
				System.out.println(0);
				return;
			}
		}
		
		int cnt = 0;
		
		for(int i=start+1; i<=n; i++) {
			for(int j=n; j<=end-1; j++) {
				if(i != j) cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
}
