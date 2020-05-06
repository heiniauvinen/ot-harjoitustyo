package app;

import dao.CreateDatabase;
import ui.Gui;

/**
 * Tämä luokka on sovelluksen käynnistystä varten.
 * @author heiniauvinen
 */
public class Matikkapeli {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CreateDatabase.createDatabase("questionsDatabase");
        Gui.main(args);

    }

}
