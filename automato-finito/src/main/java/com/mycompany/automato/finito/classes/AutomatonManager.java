package com.mycompany.automato.finito.classes;

import java.util.ArrayList;

public class AutomatonManager {
    
    char exercise;
    String description;
    ArrayList<TransitionState> transitionalState;
    ArrayList<Integer> finalState;
    
    public AutomatonManager(char exercise, String description, ArrayList<TransitionState> transitionalState, ArrayList<Integer> finalState) {
        this.exercise = exercise;
        this.description = description;
        this.transitionalState = transitionalState;
        this.finalState = finalState;
    }

    public char getExercise() {
        return exercise;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<TransitionState> getTransitionalState() {
        return transitionalState;
    }

    public ArrayList<Integer> getFinalState() {
        return finalState;
    }
    
    public int nextState(int currentState, char symbol) {
        for (TransitionState element : transitionalState) {
            if (element.currentState == currentState && element.symbols.contains(symbol)) {
                return element.nextState;
            }
        }

        return 0;
    }
    
    public boolean isFinalState(int currentState) {
        if (finalState.contains(currentState)) {
            return true;
        }

        return false;
    }
}
