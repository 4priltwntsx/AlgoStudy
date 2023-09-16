package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2174_로봇시뮬레이션 {
	static class Robot {
		int i, j, d;

		Robot(int i, int j, int d) {
			this.i = i;
			this.j = j;
			this.d = d;
		}
	}

	static int[] di = { -1, 0, 1, 0 }; // S, W, N, E
	static int[] dj = { 0, 1, 0, -1 }; // 0, 1, 2, 3
	static int A, B, N, M;
	static int[][] map;
	static Robot[] positions;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		positions = new Robot[N + 1];
		map = new int[B + 1][A + 1];
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			int j = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken());
			map[i][j] = n;
			int d = 0;
			switch (st.nextToken().charAt(0)) {
			case 'S':
				break;
			case 'W':
				d = 3;
				break;
			case 'N':
				d = 2;
				break;
			case 'E':
				d = 1;
				break;
			}

			positions[n] = new Robot(i, j, d);
		} // 로봇의 위치 입력

		// M개의 명령 수행
		boolean crash_flag = false;
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int robot = Integer.parseInt(st.nextToken());
			char cmd = st.nextToken().charAt(0);
			int repeat = Integer.parseInt(st.nextToken());
			Robot cur = positions[robot];
			int curDir = cur.d;

			if (cmd == 'L' || cmd == 'R') {
				positions[robot] = new Robot(cur.i, cur.j, getDir(cur.d, repeat, cmd));
			} else {
				int ni = cur.i;
				int nj = cur.j;

				while (repeat-- > 0) {
					ni += di[curDir];
					nj += dj[curDir];

					if (ni <= 0 || nj <= 0 || ni > B || nj > A) {
						System.out.println("Robot " + robot + " crashes into the wall");
						crash_flag = true;
						return;
					}
					if (map[ni][nj] != 0) {
						System.out.println("Robot " + robot + " crashes into robot " + map[ni][nj]);
						crash_flag = true;
						return;
					}
				}
				map[cur.i][cur.j]= 0;
				positions[robot] = new Robot(ni, nj, cur.d);
				map[ni][nj] = robot;
			}
		}
		System.out.print("OK");
	}

	public static int getDir(int now, int repeat, char ch) {
		repeat %= 4;
		if (ch == 'L') {
			if (now - repeat < 0) {
				now += 4;
			}
			return now - repeat;
		} else {
			if (now + repeat > 3) {
				now -= 4;
			}
			return now + repeat;
		}

	}
}
