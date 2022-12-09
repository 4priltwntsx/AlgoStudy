package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9519_졸려 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		
		int len = arr.length;
		char[] temp = new char[len];
		
		while(X-->0) {
			for(int i=0,j=0; i<len; i+=2) {
				temp[j++] = arr[i];
			}
			for(int i=1, j=len-1; i<len; i+=2) {
				temp[j--] = arr[i];
			}
			arr = temp.clone();
		}
		
//		System.out.println(arr[0]);
		for(int i=0; i<len; i++) {
			System.out.print(arr[i]);
		}
//		System.out.println(len);
	}
}
