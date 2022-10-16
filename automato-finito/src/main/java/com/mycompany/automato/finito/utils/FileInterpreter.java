package com.mycompany.automato.finito.utils;

import com.mycompany.automato.finito.classes.AutomatonManager;
import com.mycompany.automato.finito.classes.TransitionState;
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
                initialState = (int) line.charAt(line.length() - 1);
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
                states.add(new TransitionState(
                    Integer.parseInt(stringArray[0]), 
                    stringArray[1].chars().mapToObj(c -> (char) c).collect(Collectors.toList()),
                    Integer.parseInt(stringArray[2]))
                );
            }
        }
        System.out.println("File has been readed.");
        return new AutomatonManager('0', "", states, finalStates, initialState);
    }
}