package com.mycompany.automato.finito.classes;

import java.util.ArrayList;
import java.util.List;

public class AutomatonManager {
    
    char exercise;
    String description;
    ArrayList<TransitionState> transitionalState;
    List<Integer> finalState;
    
    public AutomatonManager(char exercise, String description, ArrayList<TransitionState> transitionalState, List<Integer> finalState) {
        this.exercise = exercise;
        this.description = description;
        this.transitionalState = transitionalState;
        this.finalState = finalState;
    }

    public char getExercise() {
        return this.exercise;
    }

    public String getDescription() {
        return this.description;
    }

    public ArrayList<TransitionState> getTransitionalState() {
        return this.transitionalState;
    }

    public List<Integer> getFinalState() {
        return this.finalState;
    }
    
    public int nextState(int currentState, char symbol) {
        for (TransitionState element : this.transitionalState) {
            if (element.currentState == currentState && element.symbols.contains(symbol)) {
                return element.nextState;
            }
        }

        return -1;
    }
    
    public boolean isFinalState(int currentState) {
        if (this.finalState.contains(currentState)) {
            return true;
        }

        return false;
    }

    public ArrayList<Integer> readSentence(char[] sentence) {
        int currentState = 0;
        ArrayList<Integer> stateSequence = new ArrayList();
        stateSequence.add(currentState);
        for (char symbol: sentence){
            currentState = this.nextState(currentState, symbol);
            stateSequence.add(currentState);
            if (currentState == -1){
                return stateSequence;
            }
        }

        return stateSequence;
    }
}
