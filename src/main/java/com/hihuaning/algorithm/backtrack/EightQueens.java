package com.hihuaning.algorithm.backtrack;
/*
八皇后问题
回溯法，想象树形结构，第i层表示放置第i行的棋子，n个列，对每个列进行试探，若能合法则进入i+1层
 */
public class EightQueens {
	public static void Trial(int [][]board, int i){
		if(i > board.length-1){
			printTrial(board);
			return ;
		}
		for(int j=0; j<board.length; j++){
			if(checkTrail(board, i, j)){
				board[i][j] = 1;
				Trial(board, i+1);
			}
			board[i][j] = 0;
		}
	}

	public static boolean checkTrail(int[][] board, int i,int j){
		for(int k=0; k<board.length; k++){
			if(k!=j && board[i][k]==1){
				return false;
			}
			if(k!=i && board[k][j]==1){
				return false;
			}
		}

		for(int m=i+1,n=j+1; m<board.length && n<board.length; m++,n++){
			if(board[m][n] == 1){
				return false;
			}
		}

		for(int m=i-1,n=j-1; m>-1 && n>-1; m--,n--){
			if(board[m][n] == 1){
				return false;
			}
		}

		for(int m=i+1, n=j-1; m<board.length && n>-1; m++,n--){
			if(board[m][n] == 1){
				return false;
			}
		}

		for(int m=i-1, n=j+1; m>-1 && n<board.length; m--,n++){
			if(board[m][n] == 1){
				return false;
			}
		}

		return true;
	}

	public static void printTrial(int [][] board){
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board.length; j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args){
		int[][] board = new int[8][8];
		Trial(board, 0);
	}
}