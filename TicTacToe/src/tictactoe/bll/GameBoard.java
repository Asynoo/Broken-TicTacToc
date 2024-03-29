package tictactoe.bll;

public class GameBoard implements IGameModel {
    private int[][] board = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    private int player = 1;

    public void setPlayer(int id) {
        player = id;
    }

    public int getNextPlayer() {
        if (player == 1) return 2;
        return 1;
    }

    public boolean play(int col, int row) {
        if (board[row][col] != 0) {
            return false;
        }
        if (board[row][col] == 0) {
            board[row][col] = player;
            return true;
        }
        return false;
    }

    public boolean isGameOver() {
        if(checkCol(0) ||checkCol(1) ||checkCol(2)) return true;
        if(checkRow(0) ||checkRow(1) ||checkRow(2)) return true;
        if(checkDiagonal()) return true;
        if(checkDraw()) return true;
        return false;
    }

    public int getWinner() {
        if(checkDraw()) return -1;
        return player;
    }

    public void newGame() {
        setPlayer(getNextPlayer());
        initBoard();
    }

    private void initBoard() {
        for (int r = 0; r <= 2; r++) {
            for (int c = 0; c <= 2; c++) {
                board[r][c] = 0;
            }
        }
    }
    private boolean checkRow(int row){
        return board[row][1] != 0 && board[row][1] == board[row][0] && board[row][1] == board[row][2];
    }
    private boolean checkCol(int col){
        return board[1][col] != 0 && board[1][col] == board[0][col] && board[1][col] == board[2][col];
    }
    private boolean checkDiagonal(){
        return board[1][1] != 0
                && (board[1][1] == board[0][0] && board[1][1] == board[2][2]
                || board[1][1] == board[0][2] && board[1][1] == board[2][0]);
    }

    private boolean checkDraw() {
        for (int r = 0; r <= 2; r++) {
            for (int c = 0; c <= 2; c++) {
                if (board[r][c] == 0) return false;
            }
        }
        return true;
    }
}
