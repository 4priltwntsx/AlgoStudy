package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1802_종이접기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			String now = br.readLine();
			
			if(dnc(0, now.length()-1, now)) {
				sb.append("YES\n");
			}else {
				sb.append("NO\n");
			}
		}
		System.out.println(sb.toString());
	}

	public static boolean dnc(int start, int end, String str) {
		if (start == end) {
			return true;
		}
		int mid = (start + end) / 2;
		for (int i = start; i < mid; i++) {
			if (str.charAt(i) == str.charAt(end - i)) {
				return false;
			}
		}
		return dnc(start, mid - 1, str) && dnc(mid + 1, end, str);
	}
}
