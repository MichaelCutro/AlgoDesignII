/**
 * Author @mikecutro
 * ${MrC}
 */
package com.main;

public class TicTacToeBoard {
	public static final int BOARD_SIZE = 3;
	// Instance Variable 2D 3x3 Matrix w/ constant 4 good practice
	String spaces[][] = new String[BOARD_SIZE][BOARD_SIZE];
	// Class Variables Pub+cons
	public static final String EMPTY_SPACE = "_";
	public static final String X_SPACE = "X";
	public static final String O_SPACE = "O";

	/**
	 * Default Constructor to initialize spaces and sets spaces to empty
	 */
	public TicTacToeBoard() {
		for (int i = 0; i < spaces.length; i++) {
			for (int j = 0; j < spaces.length; j++) {
				spaces[i][j] = EMPTY_SPACE;
			}
		}
	}

	// Clear the board same as constructing
	public void clearBoard() {
		for (int i = 0; i < spaces.length; i++) {
			for (int j = 0; j < spaces.length; j++) {
				spaces[i][j] = EMPTY_SPACE;
			}
		}
	}

	// Create method draw board w/ visualization style
	public void drawBoard() {
		for (int i = 0; i < spaces.length; i++) {
			System.out.print("  |  ");
			for (int j = 0; j < spaces.length; j++) {
				System.out.print(spaces[i][j] + "  |  ");

			}
			System.out.println();
		}

	}

	// Create Method set Space to effectively set the correct players piece position
	// based on coordinate input, return t/f if successful
	public boolean setSpace(int xVal, int yVal, String piece) {
		if (xVal >= 0 && xVal < 3) {
			if (yVal >= 0 && yVal < 3) {
				if (spaces[xVal][yVal].equals(EMPTY_SPACE)) {
					spaces[xVal][yVal] = piece;
					return true;
				}
			}
		}
		return false;
	}

	// Create helper method 'isPlayed' to decipher between X and O
	// for check victories
	private boolean isPlayed(int xVal, int yVal, boolean checkX) {
		if (checkX && spaces[xVal][yVal].equals(X_SPACE)) {
			return true;
		} else if (!checkX && spaces[xVal][yVal].equals(O_SPACE)) {
			return true;
		} else {
			return false;
		}
	}

	// Check for Horizontal space victory
	public boolean checkHorizontalVictory(boolean checkX) {
		for (int i = 0; i < spaces.length; i++) {
			if (isPlayed(i, 0, checkX) && isPlayed(i, 1, checkX) && isPlayed(i, 2, checkX)) {
				return true;
			}

		}
		for (int i = 0; i < spaces.length; i++) {
			if (isPlayed(i, 0, !checkX) && isPlayed(i, 1, !checkX) && isPlayed(i, 2, !checkX)) {
				return true;
			}
		}
		return false;
	}

	// Check for vertical space victory
	public boolean checkVerticalVictory(boolean checkX) {
		for (int i = 0; i < spaces.length; i++) {
			if (isPlayed(0, i, checkX) && isPlayed(1, i, checkX) && isPlayed(2, i, checkX)) {
				return true;
			}
		}
		for (int i = 0; i < spaces.length; i++) {
			if (isPlayed(0, i, !checkX) && isPlayed(1, i, !checkX) && isPlayed(2, i, !checkX)) {
				return true;
			}
		}
		return false;
	}

//Check for diagonal space victory 
	public boolean checkDiagonalVictory(boolean checkX) {
		if (isPlayed(0, 0, checkX) && isPlayed(1, 1, checkX) && isPlayed(2, 2, checkX)
				|| isPlayed(0, 2, checkX) && isPlayed(1, 1, checkX) && isPlayed(2, 0, checkX)) {
			return true;
		} else if (isPlayed(0, 0, !checkX) && isPlayed(1, 1, !checkX) && isPlayed(2, 2, !checkX)
				|| isPlayed(0, 2, !checkX) && isPlayed(1, 1, !checkX) && isPlayed(2, 0, !checkX)) {
			return true;
		} else {
			return false;
		}

	}

	// Create Method checkVictory, return true if horivictory or vertvictory or
	// diagvictory yield true

	public boolean checkVictory(boolean playerTurn) {
		return (checkHorizontalVictory(playerTurn) || checkVerticalVictory(playerTurn)
				|| checkDiagonalVictory(playerTurn));
	}

//Return false if board equals empty space
	public boolean checkFilledBoard() {
		for (int i = 0; i < spaces.length; i++) {
			for (int j = 0; j < spaces.length; j++) {
				if (spaces[i][j].equals(EMPTY_SPACE)) {
					return false;
				}

			}

		}
		return true;

	}

}
