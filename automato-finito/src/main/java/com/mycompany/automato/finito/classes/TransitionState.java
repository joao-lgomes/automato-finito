package com.mycompany.automato.finito.classes;

import java.util.ArrayList;

public class TransitionState {

    final int currentState;
    final int index;        
    final int nextState;
    final ArrayList<Character> symbols;
    
    public TransitionState(int index, int currentState, ArrayList<Character> symbols, int nextState) {
        this.symbols = symbols;
        this.currentState = currentState;
        this.index = index;
        this.nextState = nextState;
    }

    public int getCurrentState() {
        return currentState;
    }

    public int getIndex() {
        return index;
    }

    public int getNextState() {
        return nextState;
    }

    public ArrayList<Character> getSymbols() {
        return symbols;
    }

}
