
package com.mycompany.automato.finito;

import com.mycompany.automato.finito.classes.AutomatonManager;
import com.mycompany.automato.finito.screens.MainScreen;
import java.io.IOException;
import com.mycompany.automato.finito.utils.FileInterpreter;

/**
 *
 * @author joao_
 */
public class AutomatoFinito {

    public static void main(String[] args) {
        MainScreen screen = new MainScreen();
        screen.setVisible(true);
        screen.setLocationRelativeTo(null);
    }
}
