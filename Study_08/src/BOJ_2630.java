import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {
//색종이 만들기
	public static int white = 0; //마지막에 리턴할 흰색 색종이 수
	public static int blue = 0; //마지막에 리턴할 파란색 색종이 수
	public static int[][] map; //전역적으로 사용될 최초 색종이
	
	public static void divide(int x, int y, int size) {
		//size N이 들어오면 나누기 2 해서 divide해주는 식으로 재귀 호출
		
		// 재귀 호출 하면서 색상 체크도 해야함.
		// 1. 색상 체크해서 지금 분면의 색상이 모두 같은 색이면 white or blue +1
		if(check(x, y, size)) {
			//모두 같은 색이면 화이트인지 블루인지 색상 체크하고
			if(map[x][y] == 0) white++;
			else blue++;
			
			return; //모두 같은 색이면 분할 그만 (재귀 호출 그만)
		}
		
		//다른 색이 있다면 분할 다시 시작
		// size를 반으로 줄여서 4등분을 해야함.
		size = size/2;
		
		divide(x, y, size);
		divide(x, y+size, size);
		divide(x+size, y, size);
		divide(x+size, y+size, size);

	}
	
	public static boolean check(int x, int y, int size) {
		//색상 체크하는 함수
		//(x,y)는 분할된 색종이의 첫번째 좌표
		// 첫번째 좌표가 어떤 색상인지 확인하고 나머지 색상이랑 비교
		// 모두 같으면 true, 다르면 false를 리턴한다.
		
		int color = map[x][y];
		
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(color != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");

			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		} //input end
		
		// 1. 4등분으로 분할하기
		// 2. 색상 체크해서 하얀색 파란색 개수 증가 시키기
		
		
		
		divide(0, 0, N);
		
		
		System.out.println(white);
		System.out.println(blue);
		
		
		
		
	}
}
