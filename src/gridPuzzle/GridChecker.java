package gridPuzzle;

import java.util.Random;

public class GridChecker {

	private int[] noOfBlacksRows;
	private int[] noOfBlacksColumns;
	private String[] regexRow;
	private String[] regexColumn;

	public GridChecker() {

		this.noOfBlacksColumns = new int[25];
		this.noOfBlacksRows = new int[25];
		this.regexRow = new String[25];
		this.regexColumn = new String[25];

	}

	public void setNoBlacks() {

		this.noOfBlacksRows[0] = 19;
		this.noOfBlacksRows[1] = 8;
		this.noOfBlacksRows[2] = 14;
		this.noOfBlacksRows[3] = 17;
		this.noOfBlacksRows[4] = 17;
		this.noOfBlacksRows[5] = 6;
		this.noOfBlacksRows[6] = 19;
		this.noOfBlacksRows[7] = 6;
		this.noOfBlacksRows[8] = 15;
		this.noOfBlacksRows[9] = 9;
		this.noOfBlacksRows[10] = 14;
		this.noOfBlacksRows[11] = 13;
		this.noOfBlacksRows[12] = 12;
		this.noOfBlacksRows[13] = 17;
		this.noOfBlacksRows[14] = 15;
		this.noOfBlacksRows[15] = 11;
		this.noOfBlacksRows[16] = 13;
		this.noOfBlacksRows[17] = 10;
		this.noOfBlacksRows[18] = 14;
		this.noOfBlacksRows[19] = 10;
		this.noOfBlacksRows[20] = 15;
		this.noOfBlacksRows[21] = 19;
		this.noOfBlacksRows[22] = 18;
		this.noOfBlacksRows[23] = 8;
		this.noOfBlacksRows[24] = 17;

		this.noOfBlacksColumns[0] = 18;
		this.noOfBlacksColumns[1] = 8;
		this.noOfBlacksColumns[2] = 17;
		this.noOfBlacksColumns[3] = 16;
		this.noOfBlacksColumns[4] = 15;
		this.noOfBlacksColumns[5] = 7;
		this.noOfBlacksColumns[6] = 19;
		this.noOfBlacksColumns[7] = 5;
		this.noOfBlacksColumns[8] = 17;
		this.noOfBlacksColumns[9] = 12;
		this.noOfBlacksColumns[10] = 14;
		this.noOfBlacksColumns[11] = 11;
		this.noOfBlacksColumns[12] = 14;
		this.noOfBlacksColumns[13] = 13;
		this.noOfBlacksColumns[14] = 12;
		this.noOfBlacksColumns[15] = 12;
		this.noOfBlacksColumns[16] = 19;
		this.noOfBlacksColumns[17] = 9;
		this.noOfBlacksColumns[18] = 17;
		this.noOfBlacksColumns[19] = 8;
		this.noOfBlacksColumns[20] = 16;
		this.noOfBlacksColumns[21] = 15;
		this.noOfBlacksColumns[22] = 15;
		this.noOfBlacksColumns[23] = 15;
		this.noOfBlacksColumns[24] = 15;

		this.regexRow[0] = "w*?b{7}?w+?b{3}?w+?b{1}?w+?b{1}?w+?b{7}?w*?";
		this.regexRow[1] = "";
		this.regexRow[2] = "";
		this.regexRow[3] = "";
		this.regexRow[4] = "";
		this.regexRow[5] = "";
		this.regexRow[6] = "";
		this.regexRow[7] = "";
		this.regexRow[8] = "";
		this.regexRow[9] = "";
		this.regexRow[10] = "";
		this.regexRow[11] = "";
		this.regexRow[12] = "";
		this.regexRow[13] = "";
		this.regexRow[14] = "";
		this.regexRow[15] = "";
		this.regexRow[16] = "";
		this.regexRow[17] = "";
		this.regexRow[18] = "";
		this.regexRow[19] = "";
		this.regexRow[20] = "";
		this.regexRow[21] = "";
		this.regexRow[22] = "";
		this.regexRow[23] = "";
		this.regexRow[24] = "";

		this.regexColumn[0] = "";
		this.regexColumn[1] = "";
		this.regexColumn[2] = "";
		this.regexColumn[3] = "";
		this.regexColumn[4] = "";
		this.regexColumn[5] = "";
		this.regexColumn[6] = "";
		this.regexColumn[7] = "";
		this.regexColumn[8] = "";
		this.regexColumn[9] = "";
		this.regexColumn[10] = "";
		this.regexColumn[11] = "";
		this.regexColumn[12] = "";
		this.regexColumn[13] = "";
		this.regexColumn[14] = "";
		this.regexColumn[15] = "";
		this.regexColumn[16] = "";
		this.regexColumn[17] = "";
		this.regexColumn[18] = "";
		this.regexColumn[19] = "";
		this.regexColumn[20] = "";
		this.regexColumn[21] = "";
		this.regexColumn[22] = "";
		this.regexColumn[23] = "";
		this.regexColumn[24] = "";

		/**
		 * Reluctant quantifiers X?? X, once or not at all X*? X, zero or more times X+?
		 * X, one or more times X{n}? X, exactly n times X{n,}? X, at least n times
		 * X{n,m}? X, at least n but not more than m times
		 **/
	}

	public void fillGrid() {

		setNoBlacks();
		boolean valid = false;
		char[][] grid = new char[25][25];
		while (valid == false) {
			grid = new char[25][25];
			for (int i = 0; i < 25; i++) {
				generateRow(noOfBlacksRows[i], i, grid);
				if (!CheckRegexRow(i, grid, regexRow[i])) {
					break;
				}
				generateColumn(noOfBlacksColumns[i], i, grid);
				if (!CheckRegexColumn(i, grid, regexColumn[i])) {
					break;
				}

				if (i == 24) {
					valid = true;
				}

			}

		}
		
		printGrid(grid);
	}

	public void printGrid(char[][] grid) {
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 25; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	public char[][] generateRow(int black, int index, char[][] grid) {

		int randomN = 0;

		Random r = new Random();

		for (int i = 0; i < 25; i++) {
			if (grid[index][i] != 'b') {
				grid[index][i] = 'w';
			} else {
				black -= 1;
			}
		}

		if (black < 0) {
			fillGrid();
		}

		while (black != 0) {
			randomN = r.nextInt((24 - 0) + 1) + 0;
			if (grid[index][randomN] != 'b') {
				grid[index][randomN] = 'b';
				black -= 1;
			}

		}

		for (int i = 0; i < 25; i++) {

			System.out.print(grid[index][i]);

		}
		System.out.println();

		return grid;
	}

	public char[][] generateColumn(int black, int index, char[][] grid) {

		int randomN = 0;
		Random r = new Random();

		for (int i = 0; i < 25; i++) {
			if (grid[index][i] != 'b') {
				grid[index][i] = 'w';
			} else {
				black -= 1;
			}
		}

		if (black < 0) {
			fillGrid();
		}

		while (black != 0) {

			randomN = r.nextInt((24 - 0) + 1) + 0;
			if (grid[randomN][index] != 'b') {
				grid[randomN][index] = 'b';
				black -= 1;
			}

		}

		return grid;
	}

	public boolean CheckRegexRow(int i, char[][] grid, String expression) {
		String temp = "";
		for (int j = 0; j < 25; j++) {
			temp += grid[i][j];

		}
		if (temp.matches(expression)) {
			return true;
		}

		return false;

	}

	public boolean CheckRegexColumn(int i, char[][] grid, String expression) {

		/**
		 * String temp = ""; for (int j = 0; j < 25; j++) { temp += grid[i][j]; } if
		 * (temp.matches(expression)) { return true; }
		 **/
		return true;

	}

}