package com.mycompany.automato.finito.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class AutomatonStackManager {
    
    char exercise;
    String description;
    ArrayList<StackTransitionState> transitionalState;
    List<Integer> finalState;
    int initialState;
    private Stack<Character> stack;
    
    ArrayList<String> stackSequence;
    
    public AutomatonStackManager(char exercise, String description, ArrayList<StackTransitionState> transitionalState, List<Integer> finalState, int initialState) {
        this.exercise = exercise;
        this.description = description;
        this.transitionalState = transitionalState;
        this.finalState = finalState;
        this.initialState = initialState;
        this.stack = new Stack();
        this.stackSequence = new ArrayList<String>();
    }

    public char getExercise() {
        return this.exercise;
    }

    public String getDescription() {
        return this.description;
    }

    public ArrayList<StackTransitionState> getTransitionalState() {
        return this.transitionalState;
    }

    public List<Integer> getFinalState() {
        return this.finalState;
    }
    
    public ArrayList<Integer> nextState(int currentState, char symbol, Stack<Character> charStack) {
        ArrayList<Integer> possiblesNextStates = new ArrayList<Integer>();
        char peek = charStack.isEmpty()? ' ' : charStack.peek();
        for (StackTransitionState element : this.transitionalState) {
            if (element.currentState == currentState && (element.symbols.contains(symbol) || element.symbols.contains('?'))) {
                if(element.unstackSymbol == peek){
                    charStack.pop();
                    if(element.stackSymbol != '?') charStack.push(element.stackSymbol);
                    possiblesNextStates.add(element.nextState);
                }
                else if(element.unstackSymbol == '?'){
                    if(element.stackSymbol != '?') charStack.push(element.stackSymbol);
                    possiblesNextStates.add(element.nextState);
                }
            }
        }
        
        if (possiblesNextStates.isEmpty())
            return null;
        
        return possiblesNextStates;
    }
    
    /*public ArrayList<StackTransitionState> nextState(int currentState, char symbol) {
        ArrayList<StackTransitionState> possiblesNextStates = new ArrayList();
        
        for (StackTransitionState element : this.transitionalState) {
            if (element.currentState == currentState && (element.symbols.contains(symbol) || element.symbols.contains('?'))) {
                possiblesNextStates.add(element);
            }
        }
        
        if (possiblesNextStates.isEmpty())
            return null;
        
        return possiblesNextStates;
    }*/
    
    
    public boolean isFinalState(int currentState) {
        return this.finalState.contains(currentState);
    }

//    public ArrayList<Integer> readSentence(char[] sentence) {
//        ArrayList<StackTransitionState> possiblesNextStates = new ArrayList();
//        int currentState = this.initialState;
//        ArrayList<Integer> stateSequence = new ArrayList();
//        ArrayList<Integer> a;
//        stateSequence.add(currentState);
//        int index = 0;
//        for (char symbol: sentence){
//            possiblesNextStates = this.nextState(currentState, '?'); // HAS A EMPTY TRANSITIONAL STATE?
//            if (!possiblesNextStates.isEmpty()) {

//            }
//            
//            possiblesNextStates = this.nextState(currentState, symbol);
//            
//            if (possiblesNextStates == null){
//                stateSequence.add(-1);
//                return stateSequence;
//            }
//            
//            for(StackTransitionState state: possiblesNextStates) {
//                a = readSentence(Arrays.copyOfRange(sentence, index, sentence.length), currentState, state, (Stack<Character>) this.stack.clone());
//            }
//            
//            
//            index++;
//        }
//
//        return stateSequence;
//    }
 
    
    //ABCDE
    
    //DEF
    
    //F2
    //F1
    
    public ArrayList<Integer> readSentence(char[] sentence){
        Stack<Character> charStack = new Stack<Character>();
        return this.readSentence(sentence, this.initialState, 0, charStack);
    }
    
    public  ArrayList<Integer> readSentence(char[] sentence, int currentState, int goToState, Stack<Character> charStack) {
        this.stackSequence = new ArrayList<String>();
        
        ArrayList<Integer> possiblesNextStates = new ArrayList<Integer>();
        ArrayList<Integer> stateSequence = new ArrayList();
        ArrayList<ArrayList<Integer>> a;
        ArrayList<String> arrayStack = new ArrayList<String>();
        Map<ArrayList<Integer>, ArrayList<String>> returnMap = new  HashMap<ArrayList<Integer>, ArrayList<String>>();
        
        int newCurrentState = currentState;
        
        if (goToState != 0) {
            stateSequence.add(newCurrentState);
            newCurrentState = goToState;
        }
        
        for (int index =0; index<sentence.length; index++){
            possiblesNextStates = this.nextState(newCurrentState, sentence[index], charStack);
            arrayStack.add(charStack.toString());
            
            if (possiblesNextStates == null){
                stateSequence.add(-1);
                
                return stateSequence;
            }
            
            if(possiblesNextStates.size()==1){
                newCurrentState = possiblesNextStates.get(0);
                stateSequence.add(newCurrentState);
            }
            
            
            
            
            index++;
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

    public ArrayList<String> getStackSequence() {
        return stackSequence;
    }
    
    @Override
    public String toString() {
        return "AutomatonManager{" + "exercise=" + exercise + ", description=" + description + ", transitionalState=" + transitionalState + ", finalState=" + finalState + ", initialState=" + initialState + '}';
    }
}
