import java.util.Scanner;

public class Lotto {
	static int[] arr, temp;
	static boolean[] select;
	static int k;
	
	public static void DFS(int idx, int cnt) {
		if(cnt == 6) {

			for(int i=0; i<arr.length; i++) {
				if(select[i]) System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}

		if(idx == arr.length) return;
		select[idx] = true;
		DFS(idx+1, cnt+1);
		select[idx] = false;
		DFS(idx+1, cnt);
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = 0;
		

		while(true) {
			k = sc.nextInt();
			if(k==0) break;
			arr = new int[k];
			temp = new int[6];
			select = new boolean[k];
			for(int i=0; i<k; i++) {
				arr[i] = sc.nextInt();
//				System.out.print(arr[i]);
			}
			
			DFS(0,0);
			System.out.println();
			
		}
	}
}