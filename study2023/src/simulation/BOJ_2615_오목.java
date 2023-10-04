package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2615_오목 {
	static int[] di = { 0, 1, 1, -1 };
	static int[] dj = { 1, 0, 1, 1 };
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[19][19];
		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < 19; j++) {
			for (int i = 0; i < 19; i++) {
				if (map[i][j] != 0) {

					for (int d = 0; d < 4; d++) {
						int cnt = 1;
						int ni = i;
						int nj = j;
						while (true) {
							ni += di[d];
							nj += dj[d];
							if (ni < 0 || nj < 0 || ni >= 19 || nj >= 19)
								break;
							if (map[ni][nj] == map[i][j]) {
								cnt++;
							}
							else break;
						}
						ni = i;
						nj = j;
						while (true) {
							ni -= di[d];
							nj -= dj[d];
							if (ni < 0 || nj < 0 || ni >= 19 || nj >= 19)
								break;
							if (map[ni][nj] == map[i][j]) {
								cnt++;
							}
							else break;
						}
						if (cnt == 5) {
							sb.append(map[i][j]).append("\n");
							sb.append(i + 1).append(" ").append(j + 1);
							System.out.println(sb.toString());
							return;
						}
					}
				}
			}
		}
		System.out.println(0);
	}
}
