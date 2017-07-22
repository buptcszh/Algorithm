class EightQueue {

	private static int count;

	public static void main(String[] args) {

		int[][] board = new int[8][];
		for (int i = 0; i < 8; i++) {

			board[i] = new int[8];
		}

		solve(board, 0);

		System.out.println(count);
	}

	private static void solve(int[][] board, int i) {

		if (i == 8) {

			print(board);
			count++;

			return;
		}

		for (int j = 0; j < 8; j++) {

			board[i][j] = 1;
			if (check(board, i, j)) {

				solve(board, i+1);
			}
			board[i][j] = 0;
		}
	}

	private static void print(int[][] board) {

		for (int i = 0; i < 8; i++) {

			for (int j = 0; j < 8; j++) {

				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean check(int[][] board, int row, int col) {

		for (int i = 0; i < 8; i++) {

			if (i != row && board[i][col] == 1) return false;
		}

		for (int j = 0; j < 8; j++) {

			if (j != col && board[row][j] == 1) return false;
		}

		for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {

			if (board[i][j] == 1) return false;
		}

		for (int i = row+1, j = col+1; i < 8 && j < 8; i++, j++) {

			if (board[i][j] == 1) return false;
		}

		for (int i = row-1, j = col+1; i >= 0 && j < 8; i--, j++) {

			if (board[i][j] == 1) return false;
		}

		for (int i = row+1, j = col-1;i < 8 && j >= 0; i++, j--) {

			if (board[i][j] == 1) return false;
		}

		return true;
	}
}
