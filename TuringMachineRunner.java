// Written by James Ruogu Zhang on Oct. 13, 2020

import java.util.Scanner;

public class TuringMachineRunner {
    public static void main(String[] args) {
    	Scanner reader = new Scanner(System.in);
    	
    	// Initialize tape
    	System.out.print("Enter memory tape length: ");
    	int tapeLength = reader.nextInt();
    	Tape tape = new Tape(tapeLength);
    	
    	// Initialize program
    	System.out.print("Enter number of states (including halt): ");
    	int numOfStates = reader.nextInt();
    	System.out.println("Format of program: abc");
    	System.out.println("a: write symbol");
    	System.out.println("b: move head (0: left, 1: right)");
    	System.out.println("c: next state");
    	System.out.println("State 0 is the Halt state.");
    	Program program = new Program(numOfStates);
    	reader.nextLine();
    	for (int i = 1; i < numOfStates; i++) {
    		System.out.print("Enter program: state == " + i + ", currentSymbol == 0: ");
    		program.setInstruction(i, 0, reader.nextLine());
    		System.out.print("Enter program: state == " + i + ", currentSymbol == 1: ");
    		program.setInstruction(i, 1, reader.nextLine());
    	}
    	
    	// Initialize Turing Machine
    	System.out.print("Enter starting state (0 to " + (numOfStates - 1) + "): ");
    	int startState = reader.nextInt();
    	System.out.print("Enter starting position (0 to " + (tapeLength - 1) + "): ");
    	int startPos = reader.nextInt();
    	TuringMachine turing = new TuringMachine(tape, program, startState, startPos);
    	
    	// Run Turing Machine
    	while ((turing.getState() != 0)
    			&& (turing.getPosition() >= 0)
    			&& (turing.getPosition() <= tapeLength - 1)) {
    		// System.out.println(turing.getState());  // Debug
    		turing.runOneStep();
    		System.out.println(tape.toString()); // Print out every step
    	}
    	
    	// Print result
    	if (turing.getState() == 0) {
    		System.out.println("The Turing Machine halted.");
    	} else {
    		System.out.println("The head moved out of the tape.");
    	}
    	System.out.println(tape.toString());
    }
}
