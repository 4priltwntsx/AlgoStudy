import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String original = br.readLine();
		String target = br.readLine();
		find(original, target);
		System.out.println(answer);
	}
	
	public static void find(String now, String target) {
		if(now.length()<target.length()) {
			return;
		}
		String next = "";
		if(now.contains(target)) {
			next = now.replaceFirst(target, "-");
			answer++;
			find(next, target);
		}else {
			return;
		}
	}
}