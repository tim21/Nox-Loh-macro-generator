package lohgen.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import lohgen.Main;

public class checkBoxListener implements ActionListener {

    private int cl;
    private int hero;

    public checkBoxListener(int cl, int hero) {
        this.cl = cl;
        this.hero = hero;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean selected = ((JCheckBox) e.getSource()).isSelected();
        Main.selected[cl][hero] = selected;
    }
}
