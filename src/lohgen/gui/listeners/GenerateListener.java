package lohgen.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lohgen.gen.Generator;
import lohgen.gui.NumericTextField;

public class GenerateListener implements ActionListener {

    private static NumericTextField delayText;

    @Override
    public void actionPerformed(ActionEvent e) {
        Generator gen = new Generator(Integer.parseInt(delayText.getText()));
        gen.generateList();
        //gen.printList();
        gen.generateFile();
    }

    public static void setDelayText(NumericTextField delayText) {
        GenerateListener.delayText = delayText;
    }
}
