package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2578_빙고 {
	static int[][] map, visit;
	static int bingo;

	public static void main(String[] args) throws Exception {
		map = new int[5][5];
		visit = new int[5][5];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bingo = 0;
		int turn = 0;
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {

				int number = Integer.parseInt(st.nextToken());
				turn++;

				for (int mi = 0; mi < 5; mi++) {
					for (int mj = 0; mj < 5; mj++) {
						if (map[mi][mj] == number) {
							map[mi][mj] = 0;
							bingo = 0;

							check();
							
							if (bingo >= 3) {
								System.out.println(turn);
								System.exit(0);
							}

							break;
						}
					}
				}
			}
		}
	}

	public static void check() {
		// 행
		for (int i = 0; i < 5; i++) {
			int cnt = 0;

			for (int j = 0; j < 5; j++) {
				if (map[i][j] == 0) {
					cnt++;
				}
				if (cnt == 5) {
					bingo++;
				}
			}
		}
		// 열
		for (int j = 0; j < 5; j++) {
			int cnt = 0;
			for (int i = 0; i < 5; i++) {
				if (map[i][j] == 0)
					cnt++;
				if (cnt == 5)
					bingo++;
			}

		}

		// 대각선 왼쪽 위
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (map[i][i] == 0) {
				cnt++;
			}
		}
		if (cnt == 5)
			bingo++;
		cnt = 0;
		// 대각선 오른쪽 위
		for (int i = 4; i >= 0; i--) {
			if (map[i][4 - i] == 0) {
				cnt++;
			}
		}
		if (cnt == 5)
			bingo++;

	}
}
