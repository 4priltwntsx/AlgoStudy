package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1911_흙길보수하기 {
	static class Pool implements Comparable<Pool> {
		int start, end;

		Pool(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Pool o) {
			if (o.start == this.start)
				return this.end - o.end;
			return this.start - o.start;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long L = Integer.parseInt(st.nextToken());

		Pool[] pools = new Pool[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pools[i] = new Pool(s, end);
		}
		Arrays.sort(pools);
		int result = 0; // 필요한 널빤지 개수
		int range = 0; // 널판지로 덮은 마지막 위치
		for (int i = 0; i < N; i++) {
			int start = pools[i].start;
			int end = pools[i].end;
			if (start > range) { // 웅덩이 시작위치가 널판지 마지막 위치보다 크면
				range = start;
			}
			if (end >= range) { // 웅덩이 끝나는 위치가 널판지 마지막 위치보다 작으면 널판지를 올려야겠지
				while (end > range) { // end=range 면 끝까지 덮은거
					range += L;
					result++;
				}
			}
		}
		System.out.print(result);
	}
}
