import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int board[][];
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		answer = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}

		game(0);

		System.out.println(answer);
	}

	public static void game(int cnt) {
		if (cnt == 5) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					answer = Math.max(answer, board[i][j]);
			}
			return;
		}

		int copy[][] = new int[N][N];
		for (int i = 0; i < N; i++)
			copy[i] = board[i].clone();

		for (int i = 0; i < 4; i++) { // 상하좌우로 이동
			move(i);
			game(cnt + 1); // 한 쪽으로 스와이프 한 후, 다시 게임 또 진행

			for (int a = 0; a < N; a++)
				board[a] = copy[a].clone();
		}
	}

	public static void move(int dir) {
		switch (dir) {
		// 위로 스와이프
		case 0:
			for (int i = 0; i < N; i++) {
				int index = 0;
				int block = 0;
				for (int j = 0; j < N; j++) {
					if (board[j][i] != 0) {
						if (block == board[j][i]) {
							board[index - 1][i] = block * 2;
							block = 0;
							board[j][i] = 0;
						} else {
							block = board[j][i];
							board[j][i] = 0;
							board[index][i] = block;
							index++;
						}
					}
				}
			}
			break;
		// 아래로 스와이프
		case 1:
			for (int i = 0; i < N; i++) {
				int index = N - 1;
				int block = 0;
				for (int j = N - 1; j >= 0; j--) {
					if (board[j][i] != 0) {
						if (block == board[j][i]) {
							board[index + 1][i] = block * 2;
							block = 0;
							board[j][i] = 0;
						} else {
							block = board[j][i];
							board[j][i] = 0;
							board[index][i] = block;
							index--;
						}
					}
				}
			}
			break;
		// 왼쪽으로 스와이프
		case 2:
			for (int i = 0; i < N; i++) {
				int index = 0;
				int block = 0;
				for (int j = 0; j < N; j++) {
					if (board[i][j] != 0) {
						if (block == board[i][j]) {
							board[i][index - 1] = block * 2;
							block = 0;
							board[i][j] = 0;
						} else {
							block = board[i][j];
							board[i][j] = 0;
							board[i][index] = block;
							index++;
						}
					}
				}
			}
			break;
		// 오른쪽으로 스와이프
		case 3:
			for (int i = 0; i < N; i++) {
				int index = N - 1;
				int block = 0;
				for (int j = N - 1; j >= 0; j--) {
					if (board[i][j] != 0) {
						if (block == board[i][j]) {
							board[i][index + 1] = block * 2;
							block = 0;
							board[i][j] = 0;
						} else {
							block = board[i][j];
							board[i][j] = 0;
							board[i][index] = block;
							index--;
						}
					}
				}
			}
		}
	}
}