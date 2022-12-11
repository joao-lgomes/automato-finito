package com.mycompany.automato.finito.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TuringMachine {
    
    char exercise;
    String description;
    ArrayList<TuringTransitionState> transitionalState;
    List<Integer> finalState;
    int initialState;
    private ArrayList<String> stepByStep;
    
    public TuringMachine(char exercise, String description, ArrayList<TuringTransitionState> transitionalState, List<Integer> finalState, int initialState) {
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

    public ArrayList<TuringTransitionState> getTransitionalState() {
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
    
    public TuringTransitionState turingState(int currentState, char symbol) {
        for (TuringTransitionState element : this.transitionalState) {
            if (element.currentState == currentState && element.symbols.contains(symbol)) {
                return element;
            }
        }
        return null;
    }
    
    public boolean isFinalState(int currentState) {
        if (this.finalState.contains(currentState)) {
            return true;
        }

        return false;
    }

    public ArrayList<Integer> readSentence(String sentence) {
        int currentState = this.initialState;
        this.stepByStep = new ArrayList<String>();
        TuringTransitionState tts;
        ArrayList<Integer> stateSequence = new ArrayList();
        char[] charArray;
        int index = 0;
        stateSequence.add(currentState);
        String b;
        while(index >= 0 && index <= sentence.length()) {
            if(index == 0) {
                this.stepByStep.add(String.format("q(%d)%s", currentState, sentence));
            }
            else if(index <= sentence.length()) {
                this.stepByStep.add(sentence.substring(0, index) + String.format("q(%d)", currentState) + sentence.substring(index, sentence.length()));
            }
            
            if(index <= sentence.length() - 1)
                tts = this.turingState(currentState, sentence.charAt(index));
            else
                tts = this.turingState(currentState, '?');
            if (tts == null) {
                return stateSequence;
            }
            
            if(tts.replaceSymbol != '?'){
                charArray = sentence.toCharArray();
                charArray[index] = tts.replaceSymbol;
                sentence = String.valueOf(charArray);
                currentState = tts.nextState;
            }
            else {
                currentState = tts.nextState;
                this.stepByStep.add(sentence.substring(0, index) + String.format("q(%d)", currentState) + sentence.substring(index, sentence.length()));
            }

            stateSequence.add(tts.nextState); 
            if(tts.direction == 'D')
                index++;
            else
                index--;
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

    public ArrayList<String> getStepByStep() {
        return stepByStep;
    }

    
    @Override
    public String toString() {
        return "AutomatonManager{" + "exercise=" + exercise + ", description=" + description + ", transitionalState=" + transitionalState + ", finalState=" + finalState + ", initialState=" + initialState + '}';
    }
}
