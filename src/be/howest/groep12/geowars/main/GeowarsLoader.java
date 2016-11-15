package be.howest.groep12.geowars.main;

import be.howest.groep12.geowars.Settings.SettingsModel;
import be.howest.groep12.geowars.view.MainFrame;

/**
 *
 * @author Jonas Lauwers
 */
public class GeowarsLoader {
    
    //private GameInterface mainFrame;
    private MainFrame frame;
    private SettingsModel settings;
    private static GeowarsLoader game;

    /**
     * Loads and initializes the game completely.
     * Takes no arguments.
     * It starts with loading all the settings and components,
     * then starts the view and manages the state of the game.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        game = new GeowarsLoader();
    }
    
    public GeowarsLoader() {
        settings = SettingsModel.getSettings();
        //mainFrame = new GameInterface(settings);
        frame = new MainFrame();
    }
    
}
