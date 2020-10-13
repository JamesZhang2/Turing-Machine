// Written by James Ruogu Zhang on Oct. 13, 2020

public class Program {
    private int numOfStates;
    private int[][] symbolToWrite;
    private int[][] moveDir;
    private int[][] nextState;
    
    public Program (int numOfStates) {
    	this.numOfStates = numOfStates;
    	symbolToWrite = new int[numOfStates][2];
    	moveDir = new int[numOfStates][2];
    	nextState = new int[numOfStates][2];
    }
    
    public void setInstruction(int state, int currentSymbol, String instructions) {
    	symbolToWrite[state][currentSymbol] = Integer.parseInt(instructions.substring(0, 1));
    	moveDir[state][currentSymbol] = Integer.parseInt(instructions.substring(1, 2));
    	nextState[state][currentSymbol] = Integer.parseInt(instructions.substring(2, 3));
    }
    
    public int getSymbolToWrite(int state, int currentSymbol) {
    	return symbolToWrite[state][currentSymbol];
    }
    
    public int getMoveDir(int state, int currentSymbol) {
    	return moveDir[state][currentSymbol];
    }
    
    public int getNextState(int state, int currentSymbol) {
    	return nextState[state][currentSymbol];
    }
}
