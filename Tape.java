// Written by James Ruogu Zhang on October 13, 2020
// The memory tape is an object that stores all the symbols

public class Tape {
    private int tapeLength;
    private int[] tapeContent;
    
    public Tape(int tapeLength) {
    	this.tapeLength = tapeLength;
    	tapeContent = new int[tapeLength];
    	// All symbols are initialized to be 0
    	for (int i = 0; i < tapeLength; i++) {
    		tapeContent[i] = 0;
    	}
    }
    
    public int getSymbol(int position) {
    	return tapeContent[position];
    }
    
    public void setSymbol(int position, int symbol) {
    	tapeContent[position] = symbol;
    }
    
    public int getLength() {
    	return tapeLength;
    }
    
    public String toString() {
    	String result = "";
    	for (int i = 0; i < tapeLength - 1; i++) {
    		result += tapeContent[i];
    		result += ", ";
    	}
    	result += tapeContent[tapeLength - 1];
    	return result;
    }
}
