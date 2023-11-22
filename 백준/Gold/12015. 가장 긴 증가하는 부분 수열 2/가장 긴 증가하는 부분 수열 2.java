import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
        int N = Integer.parseInt(br.readLine());
        
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[N]; // 수열의 수들
        int[] C = new int[N]; //동적 테이블 C[k] : 해당(k) 길이를 만족하는 자리(k자리)에 오는 수의 최소값
          
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
         
        int size = 0;
        for (int i = 0; i < N; i++) {

            int pos = Arrays.binarySearch(C, 0, size, arr[i]);
            if(pos>=0) { //대상을 찾음.
                continue;
            }
            //대상을 못 찾음. 삽입 위치로
            int insertPos = Math.abs(pos)-1; //맨 뒤 또는 기존 원소 대체 자리가 될 수 있음.
             
            C[insertPos] = arr[i];
             
            if(insertPos == size) size++;
             
        }
        System.out.println(size);
	}
}