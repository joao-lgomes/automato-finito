package com.mycompany.automato.finito.classes;

import java.util.List;

public class StackTransitionState extends TransitionState {
    final char unstackSymbol;
    final char stackSymbol;

    public StackTransitionState(int currentState, List<Character> symbols, int nextState, char unstackSymbol, char stackSymbol) {
        super(currentState, symbols, nextState);
        this.unstackSymbol = unstackSymbol;
        this.stackSymbol = stackSymbol;
    }
    
}
