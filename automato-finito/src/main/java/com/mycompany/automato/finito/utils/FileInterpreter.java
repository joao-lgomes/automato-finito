package com.mycompany.automato.finito.utils;

import com.mycompany.automato.finito.classes.AutomatonManager;
import com.mycompany.automato.finito.classes.AutomatonStackManager;
import com.mycompany.automato.finito.classes.StackTransitionState;
import com.mycompany.automato.finito.classes.TransitionState;
import com.mycompany.automato.finito.classes.TuringMachine;
import com.mycompany.automato.finito.classes.TuringTransitionState;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileReader; 
import java.io.IOException; 
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class FileInterpreter {
    static public AutomatonManager initializeInstances(String filePath) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String[] stringArray;
        int initialState = 0;
        List<Integer> finalStates = List.of(0);
        Integer[] values;
        ArrayList<TransitionState> states = new ArrayList();

        while((line = br.readLine()) != null) {
            if (line.startsWith("I=")) {
                initialState = Character.getNumericValue(line.charAt(line.length() - 1));
            }
            else if (line.startsWith("F=")) {
                stringArray = line.substring(2).split(",");
                values = Arrays.stream(stringArray)
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
                finalStates = Arrays.asList(values);
            }
            else {
                stringArray = line.split(",");
                if (stringArray.length != 3) {
                    throw new IOException("Invalid state in file.");
                }
                states.add(new TransitionState(
                    Integer.parseInt(stringArray[0]), 
                    stringArray[1].chars().mapToObj(c -> (char) c).collect(Collectors.toList()),
                    Integer.parseInt(stringArray[2]))
                );
            }
        }
        System.out.println("File readed.");
        return new AutomatonManager('0', "", states, finalStates, initialState);
    }
    
        static public AutomatonStackManager initializeInstancesStack(String filePath) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String[] stringArray;
        int initialState = 0;
        List<Integer> finalStates = List.of(0);
        Integer[] values;
        ArrayList<StackTransitionState> states = new ArrayList();

        while((line = br.readLine()) != null) {
            if (line.startsWith("I=")) {
                initialState = Character.getNumericValue(line.charAt(line.length() - 1));
            }
            else if (line.startsWith("F=")) {
                stringArray = line.substring(2).split(",");
                values = Arrays.stream(stringArray)
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
                finalStates = Arrays.asList(values);
            }
            else {
                stringArray = line.split(",");
                if (stringArray.length != 5) {
                    throw new IOException("Invalid state in file.");
                }
                states.add(new StackTransitionState(
                    Integer.parseInt(stringArray[0]),
                    stringArray[1].chars().mapToObj(c -> (char) c).collect(Collectors.toList()),
                    Integer.parseInt(stringArray[2]),
                    stringArray[3].charAt(0),
                    stringArray[4].charAt(0)
                ));
            }
        }
        System.out.println("File readed.");
        return new AutomatonStackManager('0', "", states, finalStates, initialState);
    }
        
        static public TuringMachine initializeInstancesTuringMachine(String filePath) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String[] stringArray;
        int initialState = 0;
        List<Integer> finalStates = List.of(0);
        Integer[] values;
        ArrayList<TuringTransitionState> states = new ArrayList();

        while((line = br.readLine()) != null) {
            if (line.startsWith("I=")) {
                initialState = Character.getNumericValue(line.charAt(line.length() - 1));
            }
            else if (line.startsWith("F=")) {
                stringArray = line.substring(2).split(",");
                values = Arrays.stream(stringArray)
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
                finalStates = Arrays.asList(values);
            }
            else {
                stringArray = line.split(",");
                if (stringArray.length != 5) {
                    throw new IOException("Invalid state in file.");
                }
                states.add(new TuringTransitionState(
                    Integer.parseInt(stringArray[0]),
                    stringArray[1].chars().mapToObj(c -> (char) c).collect(Collectors.toList()),
                    Integer.parseInt(stringArray[2]),
                    stringArray[3].charAt(0),
                    stringArray[4].charAt(0)
                ));
            }
        }
        System.out.println("File readed.");
        return new TuringMachine('0', "", states, finalStates, initialState);
    }
}
