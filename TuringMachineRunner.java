/* Written by James Ruogu Zhang on October 13, 2020
 * This is a 2-symbol, n-state user-programmable Turing Machine
 * Users need to input the following:
 * Length of the memory tape
 * Number of states including halt
 * The instructions for each state and each symbol
 * Starting state
 * Starting position
 */

import java.util.Scanner;

public class TuringMachineRunner {
    public static void main(String[] args) {
    	Scanner reader = new Scanner(System.in);
    	
    	// Initialize tape
    	System.out.print("Enter memory tape length: ");
    	int tapeLength = reader.nextInt();
    	Tape tape = new Tape(tapeLength);
    	
    	/* Initialize program
    	 * The first number in the instruction tells the Turing Machine which symbol to write
    	 * The second number in the instruction tells the head to move left or right
    	 * The third number in the instruction tells the Turing Machine which state to go to
    	 */
    	System.out.print("Enter number of states (including halt): ");
    	int numOfStates = reader.nextInt();
    	System.out.println("Format of program: abc");
    	System.out.println("a: which symbol to write (0 or 1)");
    	System.out.println("b: move head (0: left, 1: right)");
    	System.out.println("c: next state (0 to " + (numOfStates - 1) + ")");
    	System.out.println("State 0 is the Halt state.");
    	Program program = new Program(numOfStates);
    	reader.nextLine();
    	String instruction;
    	for (int i = 1; i < numOfStates; i++) {
    		System.out.print("Enter program: state == " + i + ", currentSymbol == 0: ");
    		instruction = reader.nextLine();
    		// Check the validity of the input
    		while (instruction.length() < 3
    				|| (Integer.parseInt(instruction.substring(0, 1)) > 1)
    				|| (Integer.parseInt(instruction.substring(1, 2)) > 1)
    				|| (Integer.parseInt(instruction.substring(2)) >= numOfStates)) {
    			System.out.println("Invalid input.");
    			System.out.print("Enter program: state == " + i + ", currentSymbol == 0: ");
        		instruction = reader.nextLine();
    		}
    		program.setInstruction(i, 0, instruction);
    		
    		System.out.print("Enter program: state == " + i + ", currentSymbol == 1: ");
    		instruction = reader.nextLine();
    		// Check the validity of the input
    		while (instruction.length() < 3
    				|| (Integer.parseInt(instruction.substring(0, 1)) > 1)
    				|| (Integer.parseInt(instruction.substring(1, 2)) > 1)
    				|| (Integer.parseInt(instruction.substring(2)) >= numOfStates)) {
    			System.out.println("Invalid input.");
    			System.out.print("Enter program: state == " + i + ", currentSymbol == 1: ");
        		instruction = reader.nextLine();
    		}
    		program.setInstruction(i, 1, instruction);
    	}
    	
    	// Initialize Turing Machine
    	System.out.print("Enter starting state (0 to " + (numOfStates - 1) + "): ");
    	int startState = reader.nextInt();
    	System.out.print("Enter starting position (0 to " + (tapeLength - 1) + "): ");
    	int startPos = reader.nextInt();
    	TuringMachine turing = new TuringMachine(tape, program, startState, startPos);
    	
    	/* Run Turing Machine
    	 * The Turing Machine halts when:
    	 * It reached the Halt state, or
    	 * The head moves out of the tape
    	 */
    	System.out.println(tape.toString() + "  " + turing.toString());  // Print out starting condition
    	while ((turing.getState() != 0)
    			&& (turing.getPosition() >= 0)
    			&& (turing.getPosition() <= tapeLength - 1)) {
    		turing.runOneStep();
    		System.out.println(tape.toString() + "  " + turing.toString());  // Print out every step
    	}
    	
    	// Print result
    	if (turing.getState() == 0) {  // Halt state reached 
    		System.out.println("The Turing Machine halted after " + turing.getNumOfSteps() + " steps.");
    	} else {
    		System.out.println("The head moved out of the tape after " + turing.getNumOfSteps() + " steps.");
    	}
    	System.out.println("Final result:");
    	System.out.println(tape.toString() + "  " + turing.toString());
    }
}
