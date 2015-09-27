package gBacktracking;
/**
 * 
	Start in the leftmost columm
	If all queens are placed, return true
	for (every possible choice among the rows in this column)
		if the queen can be placed safely there,
		make that choice and then recursively try to place the rest of the queens if recursion successful, return true
		if !successful, remove queen and try another row in this column
	if all rows have been tried and nothing worked, return false to trigger backtracking
 * @author arpana
 *
 */
public class NQueens {

	static int NQ = 8;
	static Boolean[][] board = new Boolean[NQ][NQ];
	
	public static void main(String[] args){
		 
		NQueens nQueens = new NQueens();
		nQueens.solveNQueens();
	}
	
	public void solveNQueens(){
		  clearBoard();               // Set all board positions to false
		  solve(0);                  // Attempt to solve the puzzle
	}

	private Boolean solve(int col) {
		if(col > board[0].length)
			return true;
		for(int rowToTry = 0; rowToTry < board.length; rowToTry++){
			if(isSafe(rowToTry, col)){
				placeQueen(rowToTry, col);
				if(solve(col+1)) return true;
				removeQueen(rowToTry, col);
			}
		}
		
		return false;
	}
	
	private void removeQueen(int Qrow, int Qcol){
		board[Qrow][Qcol] = false;
	}
	
	private void placeQueen(int Qrow, int Qcol){
		board[Qrow][Qcol] = true;
	}
	
	boolean isSafe(int row, int col){
		return(lowerDiagClear(row,col) && rowIsClear(row, col) && upperDiagClear(row, col));
	}
	

	private boolean upperDiagClear(int Qrow, int Qcol) {

		int row, col;
		for (row = Qrow, col = Qcol; col >= 0 && row < board.length; row++, col--) {
			if(board[Qrow][col])
				return false;
		}
		return true;
	}

	private boolean rowIsClear(int Qrow, int Qcol) {

		for(int col=0; col< Qcol; col++){
			if(board[Qrow][col])
				return false;
		}
		
		return true;
	}

	private boolean lowerDiagClear(int Qrow, int Qcol) {
		int row, col;
		for (row = Qrow, col = Qcol; row >= 0 && row < board.length; row--, col--) {
			if(board[Qrow][col])
				return false;
		}
		return true;
	}

	private static void clearBoard() {
		for(int row =0; row< board.length; row++){
			for(int col = 0; col < board[0].length; col++){
				board[row][col] = false;
			}
		}
	}
	
}
