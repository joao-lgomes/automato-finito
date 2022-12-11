package com.mycompany.automato.finito.classes;

import java.util.List;

public class StackTransitionState extends TransitionState {
    final char unstackSymbol;
    final char stackSymbol;

    public StackTransitionState(int currentState, List<Character> symbols, char unstackSymbol, int nextState, char stackSymbol) {
        super(currentState, symbols, nextState);
        this.unstackSymbol = unstackSymbol;
        this.stackSymbol = stackSymbol;
    }

    @Override
    public String toString() {
        return "StackTransitionState{" + "unstackSymbol=" + unstackSymbol + ", stackSymbol=" + stackSymbol + '}';
    }
    
    
}
