/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.automato.finito.classes;

import java.util.List;

/**
 *
 * @author guga_
 */
public class TuringTransitionState extends TransitionState {
    final char replaceSymbol;
    final char direction;

    public TuringTransitionState(int currentState, List<Character> symbols, int nextState, char replaceSymbol, char direction) {
        super(currentState, symbols, nextState);
        this.replaceSymbol = replaceSymbol;
        this.direction = direction;
    }
    
}
