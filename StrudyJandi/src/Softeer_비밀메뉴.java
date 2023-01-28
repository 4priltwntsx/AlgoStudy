import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Softeer_비밀메뉴 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String secret = br.readLine().replace(" ", "");
		String button = br.readLine().replace(" ", "");
		
		if(button.contains(secret))
			System.out.println("secret");
		else System.out.println("normal");
	}
}
