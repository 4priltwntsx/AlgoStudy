package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17281_야구 {
	static int N;
	static int[][] players; // N번째 이닝 타자의 행동
	static int[] select; // 순열 배열

	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		players = new int[N + 1][10];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				players[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		select = new int[10]; // 0 생략, index 1~9 사용
		select[4] = 1; // 4번째는 1번 선수로 고정

		answer = 0;
		permutation(2); // 1번 선수는 배정완료, 2번 선수부터
		System.out.print(answer);
	}

	public static void permutation(int cnt) {
		if (cnt == 10) {
			play();
			return;
		}
		for (int i = 1; i < 10; i++) {
			if (select[i] != 0)
				continue;
			select[i] = cnt;
			permutation(cnt + 1);
			select[i] = 0; // 다시 0
		}
	}

	// 야구 경기 고고
	public static void play() {
		int score = 0;
		int idx = 1; // 이닝에서 처음 시작하는 플레이어의 idx번호
		boolean base[];

		for (int i = 1; i <= N; i++) { // i번째 이닝
			int out_count = 0;
			base = new boolean[4]; // 홈, 1루, 2루, 3루

			while (true) {
				int res = players[i][select[idx++]];

				switch (res) {
				case 0: // out
					out_count++;
					break;

				case 1: // 안타
					for (int k = 3; k > 0; k--) { // 3루부터 확인
						if (base[k]) { // 사람이 있으면 이동
							if (k == 3) { // 근데 3루에 사람이 있으면
								score++;
								base[k] = false;
								continue;
							}
							base[k] = false;
							base[k + 1] = true; // 이동완료
						}
					}
					// 홈에서 1루로 이동
					base[1] = true;
					break;

				case 2: // 2루타
					for (int k = 3; k > 0; k--) { // 3루부터 확인
						if (base[k]) { // 사람이 있으면 이동
							if (k == 3 || k == 2) { // 근데 3루,2루에 사람이 있으면
								score++;
								base[k] = false;
								continue;
							}
							base[k] = false;
							base[k + 2] = true; // 이동완료
						}
					}
					// 홈에서 2루로 이동
					base[2] = true;
					break;

				case 3: // 3루타
					for (int k = 3; k > 0; k--) { // 3루부터 확인
						if (base[k]) { // 사람이 있으면 이동
							score++; // 1, 2, 3루에 있는 사람 모두 이동
							base[k] = false;
						}
					}
					// 홈에서 3루로 이동
					base[3] = true;
					break;
				case 4: // 홈런
					for (int k = 3; k > 0; k--) { // 3루부터 확인
						if (base[k]) { // 사람이 있으면 이동
							score++; // 1, 2, 3루에 있는 사람 모두 이동
							base[k] = false;
						}
					}
					score++; // 바로 득점
					break;
				}
				if (idx == 10)
					idx = 1;

				if (out_count == 3) { // 근데 아웃 카운트가 3개가 됐다. 그러면
					break;
				}
			}
		}
		answer = answer < score ? score : answer;
	}
}
