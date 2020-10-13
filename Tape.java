// Written by James Ruogu Zhang on Oct. 13, 2020

public class Tape {
    private int tapeLength;
    private int[] tapeContent;
    
    public Tape(int tapeLength) {
    	this.tapeLength = tapeLength;
    	tapeContent = new int[tapeLength];
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
