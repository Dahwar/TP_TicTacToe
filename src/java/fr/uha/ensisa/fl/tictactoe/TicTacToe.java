/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uha.ensisa.fl.tictactoe;

/**
 *
 * @author Florent
 */
public class TicTacToe {
    public enum State {
        EMPTY,
        CROSS,
        RING
    }
    
    private State[][] grid;
    
    public TicTacToe() {
        this.grid = new State[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                this.grid[i][j] = State.EMPTY;
            }
        }
    }
    
    public State getStateCell(int x, int y) {
        return this.grid[x][y];
    }
    
    public void setStateCell(State state, int x, int y) {
        this.grid[x][y] = state;
    }
    
    public boolean win(){
        for(int i=0; i<3; i++){
            if((grid[0][i]==grid[1][i] && grid[1][i]==grid[2][i]) || 
               (grid[i][0]==grid[i][1] && grid[i][1]==grid[i][2])) {
                if((grid[0][i]!=State.EMPTY && grid[1][i]!=State.EMPTY && grid[2][i]!=State.EMPTY) ||
                   (grid[i][0]!=State.EMPTY && grid[i][1]!=State.EMPTY && grid[i][2]!=State.EMPTY)) {
                    return true;
                }
            }
        }
        
        if((grid[0][0]==grid[1][1] && grid[1][1]==grid[2][2]) ||
            (grid[0][2]==grid[1][1] && grid[1][1]==grid[2][0])) {
            if((grid[1][1]!=State.EMPTY && grid[1][1]!=State.EMPTY && grid[1][1]!=State.EMPTY) ||
               (grid[0][2]!=State.EMPTY && grid[1][1]!=State.EMPTY && grid[2][0]!=State.EMPTY)) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean haveCellEmpty() {
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(this.grid[i][j]==State.EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }
}
