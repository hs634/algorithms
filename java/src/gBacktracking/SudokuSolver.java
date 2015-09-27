package gBacktracking;
/**
 * Find row, col of an unassigned cell If there is none, return true
 * For digits from 1 to 9
 * if there is no conflict for digit at row,col
 * assign digit to row,col and recursively try fill in rest of grid if recursion successful, return true
 * if !successful, remove digit and try another
 * if all digits have been tried and nothing worked, return false to trigger backtracking
 */

/*
 * Function: SolveSudoku
 * ---------------------
 * Takes a partially filled-in grid and attempts to assign values to all
 * unassigned locations in such a way to meet the requirements for Sudoku
 * solution (non-duplication across rows, columns, and boxes). The function
 * operates via recursive backtracking: it finds an unassigned location with
 * the grid and then considers all digits from 1 to 9 in a loop. If a digit
 * is found that has no existing conflicts, tentatively assign it and recur
 * to attempt to fill in rest of grid. If this was successful, the puzzle is
 * solved. If not, unmake that decision and try again.  If all digits have
 * been examined and none worked out, return false to backtrack to previous
 * decision point.
 */
public class SudokuSolver {
	
	static int NQ = 8;
	static Integer[][] board = new Integer[NQ][NQ];
	
	boolean solveSudoku(){
		Integer row = 0, col = 0;
		if(!findUnassignedLocation(row, col)) 
			return true;
		for(int num =1; num<=9;num++){	// consider digits 1 to 9
			if(noConflict(row,col, num)){ //looks good
				board[row][col] = num;  // assign the num
				if(solveSudoku()) return true; //recur, if success yay!
				board[row][col] = -1; // Unassign - Undo
			}
		}
		return false;
	}

	private boolean noConflict(int row, int col, int num) {
		//mode 3 to get the begin of 3*3 matrix inside 9*9. 
		// so if 5th col, then it would give0+5%3, 1+ 5%3, 2+ 5%3
		return !usedInRow(row, num) && !usedInCol(col, num) && !usedInBox(row - row%3 , col - col%3, num);
	}

	private boolean usedInBox(int boxStartRow, int boxStartCol, int num) {
		 for (int row = 0; row < 3; row++){
			 for (int col = 0; col < 3; col++){
				 if(board[row+boxStartRow][col+boxStartCol] == num)
					 return true;
			 }
		 }
		return false;
	}

	private boolean usedInCol(int col, int num) {
		for (int row = 0; row < board[0].length; row++)
		      if (board[row][col] == num) return true;
		   return false;
	}

	private boolean usedInRow(int row, int num) {
		for (int col = 0; col < board[0].length; col++)
		      if (board[row][col] == num) return true;
		   return false;
	}

	private boolean findUnassignedLocation(Integer row, Integer col) {
		 for (row = 0; row < board.length; row++){
			 for (col = 0; col < board[0].length; col++){
				 if(board[row][col] == -1)
					 return true;
			 }
		 }
		return false;
	}

}
