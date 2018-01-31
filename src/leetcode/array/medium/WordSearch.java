/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.array.medium;

/**
 *
 * @author youngjucho
 */
public class WordSearch {
    boolean[][] visited ;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean search (char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) 
            return true;
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || word.charAt(index) != board[i][j])  
            return false;
            
        visited[i][j] = true;
        
        if (search(board, word, i-1, j, index+1) || 
                search(board, word, i+1, j, index+1) ||
                search(board, word, i, j-1, index+1) ||
                search(board, word, i, j+1, index+1)) {
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }
    
    
    
}
