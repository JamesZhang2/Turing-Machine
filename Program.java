/* Written by James Ruogu Zhang on October 13, 2020
 * The Program stores the instructions for a Turing Machine to operate
 * The instructions are stored in three 2D arrays:
 * symbolToWrite: Which symbol (0 or 1) should be written on the current position of the tape
 * moveDir: In which direction (0: left or 1: right) should the head of the Turing Machine move
 * nextState: Which state should the Turing Machine go to
 * The indices of the arrays are:
 * 1. the current state of the Turing Machine
 * 2. the current symbol on the tape
 */

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
    	/* When an instruction is passed, it consists of three parts.
    	 * First number: which symbol to write (0 or 1)
    	 * Second number: which direction to move the head (0: left or 1: right)
    	 * Third number: which state to go to
    	 * We need to separate the three parts using the substring method
    	 * and store them in separate 2D arrays
    	 */
    	symbolToWrite[state][currentSymbol] = Integer.parseInt(instructions.substring(0, 1));
    	moveDir[state][currentSymbol] = Integer.parseInt(instructions.substring(1, 2));
    	nextState[state][currentSymbol] = Integer.parseInt(instructions.substring(2));
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
