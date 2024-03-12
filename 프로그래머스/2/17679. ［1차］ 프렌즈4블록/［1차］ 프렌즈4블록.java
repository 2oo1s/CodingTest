import java.util.*;

class Solution {

    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++)
            map[i] = board[i].toCharArray();

        while (true) {
            boolean flag = false;
            boolean[][] check = new boolean[m][n];

            // 2 * 2 블록 찾기
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] != '.' && map[i][j] == map[i + 1][j]
                        && map[i][j] == map[i + 1][j + 1] && map[i][j] == map[i][j + 1]) {
                        check[i][j] = true;
                        check[i + 1][j] = true;
                        check[i][j + 1] = true;
                        check[i + 1][j + 1] = true;
                        flag = true;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (check[i][j])
                        map[i][j] = '.';
                }
            }

            // 없애는 블록 없는 경우에 탐색 멈춤
            if (!flag)
                break;

            // 세로줄씩 터진 블록 자리 메꾸기
            for (int j = 0; j < n; j++) {
                Queue<Character> q = new LinkedList<>();

                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] != '.')
                        q.add(map[i][j]);
                }

                if (q.size() < m) { // 빈칸이 생긴 경우
                    int spare = m - q.size();
                    for (int i = 0; i < spare; i++)
                        q.add('.');
                }

                // 세로줄씩 다시 블록 넣기
                for (int i = m - 1; i >= 0; i--)
                    map[i][j] = q.poll();
            }
        }

        // '.' 부분 cnt
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '.')
                    answer++;
            }
        }
        return answer;
    }
}