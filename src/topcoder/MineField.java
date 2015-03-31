package topcoder;

/**
 * Created by jalpanranderi on 11/29/14.
 */
public class MineField {
    public static void main(String[] args) {
        new MineField().getMineField("(0,0)(1,0)(2,0)(3,0)(4,0)");
    }

        public String[] getMineField(String mineLocations){
            char[][] board = new char[9][9];

            plotMines(board, mineLocations.toCharArray());

            plotClues(board);

            String[] ans = new String[9];
            for(int i=0; i < ans.length; i++){
                ans[i] = String.valueOf(board[i]);
            }

            return ans;
        }


        private void plotMines(char[][] board, char[] mines){
            for(int i = 0; i < mines.length - 4; i+=5){
                int x = mines[i + 1] - '0';
                int y = mines[i + 3] - '0';

                board[x][y] = 'M';
            }

        }

        private void plotClues(char[][] board){
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board.length; j++){
                    if(board[i][j] != 'M'){
                        board[i][j] = nearMineCount(board, i, j);
                    }
                }
            }
        }

        private char nearMineCount(char[][] board, int x, int y){
            int count = 0;

            int start_x = Math.max(0, x - 1);
            int start_y = Math.max(0, y - 1);
            int end_x = Math.min(8, x + 1);
            int end_y = Math.min(8, y + 1);

            for(int i = start_x; i <= end_x; i++){
                for(int j = start_y; j <= end_y; j++){
                    if(i != x && j != y && board[i][j] == 'M'){
                        count++;
                    }
                }
            }

            return (char) ('0' + count);
        }


}
