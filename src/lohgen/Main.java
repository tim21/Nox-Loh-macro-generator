package lohgen;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import lohgen.gui.GenGUI;

public class Main {

    public static boolean[][] selected;

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "look and feel error", ex);
        }

        selected = new boolean[Consts.HERO_NAMES.length][];
        for (int cl = 0; cl < Consts.HERO_NAMES.length; cl++) {
            selected[cl] = new boolean[Consts.HERO_NAMES[cl].length];
        }

        GenGUI gui = new GenGUI();
    }
}
