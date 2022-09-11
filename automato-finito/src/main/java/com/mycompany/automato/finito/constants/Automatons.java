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
        List<Character> AaZ = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r' ,'s' ,'t', 'u', 'v', 'w', 'x', 'y', 'z');
        List<Character> BaZ = Arrays.asList('b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r' ,'s' ,'t', 'u', 'v', 'w', 'x', 'y', 'z');
        List<Character> CaZ = Arrays.asList('c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r' ,'s' ,'t', 'u', 'v', 'w', 'x', 'y', 'z');
        List<Character> AaZsemB = Arrays.asList('a', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r' ,'s' ,'t', 'u', 'v', 'w', 'x', 'y', 'z');
        List<Character> AllNumbers = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        List<Character> Even = Arrays.asList('0', '2', '4', '6', '8');
        List<Character> Odd = Arrays.asList('1', '3', '5', '7', '9');
        List<Character> Zero = Arrays.asList('0');
        List<Character> One = Arrays.asList('1');
        List<Character> TwoToNine = Arrays.asList('2', '3', '4', '5', '6', '7', '8', '9');
        List<Character> NumbersAndLetters = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r' ,'s' ,'t', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        List<Character> Symbols = Arrays.asList('+', '-', ',', 'e');
        List<Character> Operators = Arrays.asList('+', '-');
        List<Character> OperatorsAndComma = Arrays.asList('+', '-', ',');
        List<Character> Comma = Arrays.asList(',');
        List<Character> Exponent = Arrays.asList('e');
        List<Character> ExponentAndComma = Arrays.asList('e', ',');
        List<Character> OperatorsAndExponent = Arrays.asList('+', '-', 'e');
        List<Character> NumberAndSymbols = Arrays.asList('+', '-', ',', 'e', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        
        states.add(new TransitionState(0, A, 1));
        states.add(new TransitionState(0, B, 3));
        states.add(new TransitionState(3, AeB, 3));
        states.add(new TransitionState(1, A, 1));
        states.add(new TransitionState(1, B, 2));
        states.add(new TransitionState(2, A, 1));
        states.add(new TransitionState(2, B, 2));

        automatons.add(new AutomatonManager('a', "Começa com a e termina com b", states, Arrays.asList(2)));
        
        states = new ArrayList();

        //new TransitionState(CURRENT, SÍMBOLO, PRÓXIMO)
        states.add(new TransitionState(0, A, 1));
        states.add(new TransitionState(0, B, 0));
        states.add(new TransitionState(1, A, 2));
        states.add(new TransitionState(1, B, 0));
        states.add(new TransitionState(2, A, 3));
        states.add(new TransitionState(2, B, 0));
        states.add(new TransitionState(3, AeB, 3));
        
        automatons.add(new AutomatonManager('b', "Possui aaa como subcadeia", states, Arrays.asList(3)));
        
        states = new ArrayList();
        
        states.add(new TransitionState(0, A, 8));
        states.add(new TransitionState(0, B, 1));
        states.add(new TransitionState(1, A, 2));
        states.add(new TransitionState(1, B, 8));
        states.add(new TransitionState(2, A, 8));
        states.add(new TransitionState(2, B, 3));
        states.add(new TransitionState(3, A, 4));
        states.add(new TransitionState(3, B, 8));
        states.add(new TransitionState(4, A, 4));
        states.add(new TransitionState(4, B, 5));
        states.add(new TransitionState(5, A, 6));
        states.add(new TransitionState(5, B, 4));
        states.add(new TransitionState(6, A, 4));
        states.add(new TransitionState(6, B, 7));
        states.add(new TransitionState(7, A, 6));
        states.add(new TransitionState(7, B, 5));
        states.add(new TransitionState(8, AeB, 8));
        
        automatons.add(new AutomatonManager('c', "Possui baba como prefixo e abab como sufixo", states, Arrays.asList(7)));
        
        states = new ArrayList();
        
        states.add(new TransitionState(0, A, 0));
        states.add(new TransitionState(0, B, 1));
        states.add(new TransitionState(1, A, 2));
        states.add(new TransitionState(1, B, 0));
        states.add(new TransitionState(2, A, 0));
        states.add(new TransitionState(2, B, 3));
        states.add(new TransitionState(3, A, 4));
        states.add(new TransitionState(3, B, 0));
        states.add(new TransitionState(4, A, 5));
        states.add(new TransitionState(4, B, 6));
        states.add(new TransitionState(5, A, 5));
        states.add(new TransitionState(5, B, 7));
        states.add(new TransitionState(6, A, 10));
        states.add(new TransitionState(6, B, 7));
        states.add(new TransitionState(7, A, 8));
        states.add(new TransitionState(7, B, 5));
        states.add(new TransitionState(8, A, 5));
        states.add(new TransitionState(8, B, 9));
        states.add(new TransitionState(9, A, 10));
        states.add(new TransitionState(9, B, 5));
        states.add(new TransitionState(10, AeB, 10));
        
        automatons.add(new AutomatonManager('d', "Possui no máximo uma única ocorrência da cadeia baba", states, Arrays.asList(0,1,2,3,4,5,6,7,8,9)));
        
        states = new ArrayList();
        
        states.add(new TransitionState(0, A, 0));
        states.add(new TransitionState(0, B, 1));
        states.add(new TransitionState(1, A, 2));
        states.add(new TransitionState(1, B, 1));
        states.add(new TransitionState(2, A, 1));
        states.add(new TransitionState(2, B, 3));
        states.add(new TransitionState(3, A, 4));
        states.add(new TransitionState(3, B, 1));
        states.add(new TransitionState(4, AeB, 4));
        
        automatons.add(new AutomatonManager('e', "Não possui ocorrência da cadeia baba", states, Arrays.asList(0,1,2,3)));
          
        states = new ArrayList();
        
        states.add(new TransitionState(0, A, 1));
        states.add(new TransitionState(0, B, 5));
        states.add(new TransitionState(1, A, 2));
        states.add(new TransitionState(1, B, 5));
        states.add(new TransitionState(2, A, 1));
        states.add(new TransitionState(2, B, 3));
        states.add(new TransitionState(3, A, 5));
        states.add(new TransitionState(3, B, 4));
        states.add(new TransitionState(4, A, 5));
        states.add(new TransitionState(4, B, 3));
        states.add(new TransitionState(5, AeB, 6));
        
        automatons.add(new AutomatonManager('f', "Possui ocorrência par de a seguida por ocorrência ímpar de b", states, Arrays.asList(3)));
        
        states = new ArrayList();
        
        states.add(new TransitionState(0, A, 1));
        states.add(new TransitionState(0, B, 3));
        states.add(new TransitionState(0, CaZ, 5));
        states.add(new TransitionState(1, A, 2));
        states.add(new TransitionState(1, BaZ, 1));
        states.add(new TransitionState(2, A, 1));
        states.add(new TransitionState(2, BaZ, 2));
        states.add(new TransitionState(3, AaZsemB, 3));
        states.add(new TransitionState(3, B, 4));
        states.add(new TransitionState(4, B, 3));
        states.add(new TransitionState(4, AaZsemB, 4));
        states.add(new TransitionState(5, AaZ, 5));
        
        automatons.add(new AutomatonManager('g', "Começa com a e possui ocorrência par de a 's ou começa com b e possui ocorrência impar de b 's", states, Arrays.asList(2,3)));
       
        states = new ArrayList();
        
        states.add(new TransitionState(0, Zero, 1));
        states.add(new TransitionState(0, One, 1));
        states.add(new TransitionState(0, TwoToNine, 3));
        states.add(new TransitionState(1, Even, 1));
        states.add(new TransitionState(1, Odd, 2));
        states.add(new TransitionState(2, Even, 2));
        states.add(new TransitionState(2, Odd, 1));
        states.add(new TransitionState(3, AllNumbers, 3));
        
        automatons.add(new AutomatonManager('h', "Inicia-se com 0 e a soma de todos os seus dígitos é par, ou inicia-se com 1 e a soma de todos os seus dígitos é impar", states, Arrays.asList(1)));
        
        states = new ArrayList();
        
        states.add(new TransitionState(0, AaZ, 1));
        states.add(new TransitionState(0, AllNumbers, 2));
        states.add(new TransitionState(1, NumbersAndLetters, 1));
        states.add(new TransitionState(2, NumbersAndLetters, 2));
        
        automatons.add(new AutomatonManager('i', "Inicia-se com uma letra, possuindo a seguir qualquer combinação de letras e dígitos", states, Arrays.asList(1)));
        
        states = new ArrayList();
        
        states.add(new TransitionState(0, AllNumbers, 1));
        states.add(new TransitionState(0, Operators, 3));
        states.add(new TransitionState(0, ExponentAndComma, 2));
        states.add(new TransitionState(1, AllNumbers, 1));
        states.add(new TransitionState(1, Comma, 4));
        states.add(new TransitionState(1, Exponent, 6));
        states.add(new TransitionState(1, Operators, 2));
        states.add(new TransitionState(2, NumberAndSymbols, 2));
        states.add(new TransitionState(3, AllNumbers, 1));
        states.add(new TransitionState(3, Symbols, 2));
        states.add(new TransitionState(4, AllNumbers, 5));
        states.add(new TransitionState(4, Symbols, 2));
        states.add(new TransitionState(5, AllNumbers, 5));
        states.add(new TransitionState(5, OperatorsAndComma, 2));
        states.add(new TransitionState(5, Exponent, 6));
        states.add(new TransitionState(6, Operators, 7));
        states.add(new TransitionState(6, AllNumbers, 8));
        states.add(new TransitionState(6, ExponentAndComma, 2));
        states.add(new TransitionState(7, AllNumbers, 8));
        states.add(new TransitionState(7, Symbols, 2));
        states.add(new TransitionState(8, AllNumbers, 8));
        states.add(new TransitionState(8, Comma, 9));
        states.add(new TransitionState(8, OperatorsAndExponent, 2));
        states.add(new TransitionState(9, AllNumbers, 10));
        states.add(new TransitionState(9, Symbols, 2));
        states.add(new TransitionState(10, AllNumbers, 10));
        states.add(new TransitionState(10, Symbols, 2));
        
        automatons.add(new AutomatonManager('j', "É um número inteiro, um número decimal ou um número representado em notação científica", states, Arrays.asList(1, 5, 8, 10)));
        
        return automatons;
    }
}
