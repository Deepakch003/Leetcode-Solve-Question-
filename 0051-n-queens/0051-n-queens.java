class Solution {
    public static boolean isSafe(char board[][],int row,int col){
       for(int i=row-1;i>=0;i--){
        if(board[i][col]=='Q'){
            return false;
        }
       }

       for(int i=row-1,j=col-1;j>=0 && i>=0;i--,j--){
        if(board[i][j]=='Q'){
            return false;
        }
       }

       for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
        if(board[i][j]=='Q'){
            return false;
        }
       }

       return true;
    }

    public static void helper(char board[][] , int row , List<List<String>> ans){
        if(row==board.length){
            ArrayList<String> ds = new ArrayList<>();

            for(int i=0;i<board.length;i++){
                ds.add(new String(board[i]));
            }

            ans.add(ds);
            return;
        }

        for(int col=0;col<board.length;col++){
            if(isSafe(board,row,col)){
            board[row][col]='Q';
            helper(board,row+1,ans);
            board[row][col]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }

        List<List<String>> ans = new ArrayList<>();

        helper(board,0,ans);

        return ans;


        
    }
}