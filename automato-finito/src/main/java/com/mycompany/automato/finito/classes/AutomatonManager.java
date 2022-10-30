package com.mycompany.automato.finito.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AutomatonManager {
    
    char exercise;
    String description;
    ArrayList<TransitionState> transitionalState;
    List<Integer> finalState;
    int initialState;
    
    public AutomatonManager(char exercise, String description, ArrayList<TransitionState> transitionalState, List<Integer> finalState, int initialState) {
        this.exercise = exercise;
        this.description = description;
        this.transitionalState = transitionalState;
        this.finalState = finalState;
        this.initialState = initialState;
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
        int currentState = this.initialState;
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
    
    public boolean isDeterministicAutomaton() {
        ArrayList<Character> allSymbols = new ArrayList();   
        Map<Integer, ArrayList<Character>> allTransitions = new HashMap<>();
        for (TransitionState state : this.transitionalState) {
            if (allTransitions.get(state.currentState) == null) {
                allTransitions.put(state.currentState, new ArrayList<Character>());
            }
            for(Character symbol : state.getSymbols()) {
                allTransitions.get(state.currentState).add(symbol);
                if (!allSymbols.contains(symbol)) {
                    allSymbols.add(symbol);
                }
            }
        }
        
        Set<Character> characterSet = new HashSet<Character>();
        
        for(ArrayList<Character> value : allTransitions.values()) {
            if (value.size() != allSymbols.size()) {
                return false;
            }
            if((value.contains("")) || (value.contains(" "))) {
                return false;
            }
            for (Character c : value) {
                characterSet.add(c);
            }
            if(characterSet.size() != value.size())  {
                return false;
            }
        }
        return true;
    }
            
    @Override
    public String toString() {
        return "AutomatonManager{" + "exercise=" + exercise + ", description=" + description + ", transitionalState=" + transitionalState + ", finalState=" + finalState + ", initialState=" + initialState + '}';
    }
}
