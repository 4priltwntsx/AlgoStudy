package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_11256_사탕 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int J = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			Long[] boxes = new Long[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				long R = Long.parseLong(st.nextToken());
				long C = Long.parseLong(st.nextToken());
				boxes[i] = R * C;
			}
			Arrays.sort(boxes, new Comparator<Long>() {
				public int compare(Long l1, Long l2) {
					return (int) (l2 - l1);
				}
			});
			int answer = 0;
			for (Long size : boxes) {
				if (J == 0)
					break;
				if (size >= J) {
					answer++;
					break;
				} else if (size < J) {
					J -= size;
					answer++;
				}
			}

			System.out.println(answer);
		}

	}
}
