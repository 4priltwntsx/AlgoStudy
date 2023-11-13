public class Main {

    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int maxSquareSize;

    public static int solution(int n, int k, int[][] grid) {
        maxSquareSize = 0;

        for (int color = 1; color <= 3; color++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == color) {
                        dfs(i, j, color, k - 1, n, grid, 1, new boolean[n][n]);
                    }
                }
            }
        }

        return maxSquareSize * maxSquareSize;
    }

    public static void dfs(int x, int y, int color, int remaining, int n, int[][] grid, int size, boolean[][] visited) {
        maxSquareSize = Math.max(maxSquareSize, size);

        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY]) {
                if (grid[newX][newY] == color) {
                    visited[newX][newY] = true;
                    dfs(newX, newY, color, remaining, n, grid, size + 1, visited);
                    visited[newX][newY] = false; // Backtrack
                } else if (remaining > 0) {
                    visited[newX][newY] = true;
                    dfs(newX, newY, color, remaining - 1, n, grid, size + 1, visited);
                    visited[newX][newY] = false; // Backtrack
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 3;
        int[][] grid = {
            {1, 2, 2, 2},
            {1, 2, 1, 1},
            {1, 2, 2, 1},
            {3, 2, 1, 1}
        };

        int result = solution(n, k, grid);
        System.out.println("최대 정사각형 넓이: " + result); // 결과 출력
    }
}
