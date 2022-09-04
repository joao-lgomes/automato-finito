/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.automato.finito.constants;

import com.mycompany.automato.finito.classes.AutomatonManager;
import com.mycompany.automato.finito.classes.TransitionState;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public final class Automatons {

    public ArrayList<AutomatonManager> initializeAutomatonConstants(){
        ArrayList<AutomatonManager> automatons = new ArrayList();
        ArrayList<TransitionState> states = new ArrayList();
        List<Character> A = Arrays.asList('a');
        List<Character> AeB = Arrays.asList('a', 'b');
        List<Character> B = Arrays.asList('b');
        
        states.add(new TransitionState(0, A, 1));
        states.add(new TransitionState(0, B, 3));
        states.add(new TransitionState(3, AeB, 3));
        states.add(new TransitionState(1, A, 1));
        states.add(new TransitionState(1, B, 2));
        states.add(new TransitionState(2, A, 1));
        states.add(new TransitionState(2, B, 2));

        automatons.add(new AutomatonManager('a', "começa com a e termina com b", states, Arrays.asList(2)));
        
        states = new ArrayList();

        //new TransitionState(CURRENT, SÍMBOLO, PRÓXIMO)
        states.add(new TransitionState(0, A, 1));
        states.add(new TransitionState(0, B, 0));
        states.add(new TransitionState(1, A, 2));
        states.add(new TransitionState(1, B, 0));
        states.add(new TransitionState(2, A, 3));
        states.add(new TransitionState(2, B, 0));
        states.add(new TransitionState(3, AeB, 3));
        
        automatons.add(new AutomatonManager('b', "possui aaa como subcadeia", states, Arrays.asList(3)));
        
        System.out.println(automatons);
        return automatons;
    }
}
