/* Written by James Ruogu Zhang on October 13, 2020
 * The Turing Machine asks the program for instructions
 * The Program returns an instruction based on the state and the current symbol
 * Then the Turing Machine writes a symbol,
 * moves to the left or right,
 * and changes to the next state.
 */

public class TuringMachine {
    private Tape tape;
    private Program program;
    private int state;
    private int position;
    private int numOfSteps = 0;
    
    public TuringMachine(Tape tape, Program program, int startState, int startPos) {
    	this.tape = tape;
    	this.program = program;
    	state = startState;
    	position = startPos;
    }
    
    public void runOneStep() {
    	numOfSteps++;
    	int currentSymbol = tape.getSymbol(position);
    	int symbolToWrite = program.getSymbolToWrite(state, currentSymbol);
    	int moveDir = program.getMoveDir(state, currentSymbol);
    	int nextState = program.getNextState(state, currentSymbol);
    	writeSymbol(symbolToWrite);
    	moveHead(moveDir);
    	setState(nextState);
    }
    
    public void writeSymbol(int symbolToWrite) {
    	tape.setSymbol(position, symbolToWrite);
    }
    
    
    public void moveHead(int moveDir) {
    	if (moveDir == 0) {  // Move head to the left
    		position--;
    	} else {  // Move head to the right
    		position++;
    	}
    }
    
    public void setState(int nextState) {
    	state = nextState;
    }
    
    public int getState() {
    	return state;
    }
    
    public int getPosition() {
    	return position;
    }
    
    public int getNumOfSteps() {
    	return numOfSteps;
    }
    
    public String toString() {
    	return ("Current state: " + state + ", Current position: " + position);
    }
}
