// Written by James Ruogu Zhang on Oct. 13, 2020

public class TuringMachine {
    private Tape tape;
    private Program program;
    private int state;
    private int position;
    
    public TuringMachine(Tape tape, Program program, int startState, int startPos) {
    	this.tape = tape;
    	this.program = program;
    	state = startState;
    	position = startPos;
    }
    
    public void runOneStep() {
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
    	if (moveDir == 0) {
    		position--;
    	} else {
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
}
