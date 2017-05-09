
/*
 * Author: Billy Romansky
 * Date: May 11, 2017
 * This program will replicate the Minesweeper game from OS/2.
 * The program will create a mine field for the user. The
 * user will choose each place on the mine field and either
 * accumulate a score or hit a mine and lose the game.
 */
import java.util.Scanner;

public class Minesweeper {

	public static void revealCell(Cell[][] A) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter Row selection: ");
		int RowInput = keyboard.nextInt();
		System.out.print("Enter Column selection: ");
		int ColInput = keyboard.nextInt();

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				A[i][j].setRevealStatus(true);
			}
		}
	}

	public static int difficulty() {
		Scanner keyboard = new Scanner(System.in);
		int difficulty = 0;
		System.out.println("1. Easy - 8 x 8 Grid");
		System.out.println("2. Intermediate - 12 x 12 Grid");
		System.out.println("3. Expert - 16 x 16 Grid");

		do {
			System.out.print("Enter difficulty: ");
			difficulty = keyboard.nextInt();
		} while ((difficulty < 1) || (difficulty > 3));

		switch (difficulty) {
		case 1:
			return 8;
		case 2:
			return 12;
		case 3:
			return 16;
		default:
			return 8;
		}
	}

	public static void printField(Cell[][] A) {
		System.out.print("   ");
		for (int k = 0; k < A[0].length; k++) {
			System.out.printf(" %4d", (k + 1));
		}
		System.out.println("");
		System.out.println("----------------------------------");
		for (int i = 0; i < A.length; i++) {
			System.out.printf("%3d |", (i + 1));
			for (int j = 0; j < A[0].length; j++) {

				if (A[i][j].getRevealStatus() == false) {
					System.out.print(" [] ");
				}

				if (A[i][j].getRevealStatus() == true) {
					if (A[i][j].getBombStatus() == true) {
						System.out.print(" Q ");
					} else if (A[i][j].getEmptyStatus() == true) {
						System.out.print("   ");
					} else if (A[i][j].getScoreCellStatus() == true) {
						System.out.print(" S ");
					}
				}

			}
			System.out.println("");
		}
		System.out.println("----------------------------------");
	}

	public static void populateField(Cell[][] A) {
		int IfBomb = 0;
		int IfEmpty = 0;
		int IfScoreCell = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {

				A[i][j].setRevealStatus(false);

				IfBomb = (int) (Math.random() * 2) + 1;
				IfEmpty = (int) (Math.random() * 2) + 1;
				IfScoreCell = (int) (Math.random() * 2) + 1;

				// Makes sure no cells have conflicting properties
				if (IfBomb == 1) {
					IfEmpty = 0;
					IfScoreCell = 0;
				} else if (IfEmpty == 1) {
					IfBomb = 0;
					IfScoreCell = 0;
				} else if (IfScoreCell == 1) {
					IfBomb = 0;
					IfEmpty = 0;
				}

				// Sets if the current cell is a bomb
				switch (IfBomb) {
				case 1:
					A[i][j].setBombStatus(false);
				case 2:
					A[i][j].setBombStatus(true);
					A[i][j].setEmptyStatus(false);
					A[i][j].setScoreCellStatus(false);
					A[i][j].setValue(0);
				}

				// Sets if the current cell is empty
				switch (IfEmpty) {
				case 1:
					A[i][j].setEmptyStatus(false);
				case 2:
					A[i][j].setEmptyStatus(true);
					A[i][j].setBombStatus(false);
					A[i][j].setScoreCellStatus(false);
				}

				// Sets if the current cell holds a score
				switch (IfScoreCell) {
				case 1:
					A[i][j].setScoreCellStatus(false);
				case 2:
					A[i][j].setScoreCellStatus(true);
					A[i][j].setBombStatus(false);
					A[i][j].setEmptyStatus(false);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		int dim = difficulty();

		Cell field[][] = new Cell[dim][dim];
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				field[i][j] = new Cell(false, false, false, false, 0);
			}
		}

		populateField(field);

		printField(field);

		revealCell(field);

		printField(field);
	}

}
