package com.mycompany.automato.finito.classes;

import java.util.ArrayList;
import java.util.List;

public class TransitionState {

    final int currentState;
    final int nextState;
    final List<Character> symbols;
    
    public TransitionState(int currentState, List<Character> symbols, int nextState) {
        this.symbols = symbols;
        this.currentState = currentState;
        this.nextState = nextState;
    }

    public int getCurrentState() {
        return currentState;
    }

    public int getNextState() {
        return nextState;
    }

    public List<Character> getSymbols() {
        return symbols;
    }

    @Override
    public String toString() {
        return "TransitionState{" + "currentState=" + currentState + ", nextState=" + nextState + ", symbols=" + symbols + '}';
    }

    
    
}
