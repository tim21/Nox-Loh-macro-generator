package lohgen.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lohgen.gen.Generator;
import lohgen.gui.NumericTextField;

public class GenerateListener implements ActionListener {

    private static NumericTextField delayText;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (checkInput()) {
            Generator gen = new Generator(Integer.parseInt(delayText.getText()));
            gen.generateList();
            switch (e.getActionCommand()) {
                case "text":
                    gen.generateText();
                    break;
                case "install":
                    gen.install();
                    break;
                case "import":
                    gen.generateImport();
                    break;
            }
        }
    }

    public static void setDelayText(NumericTextField delayText) {
        GenerateListener.delayText = delayText;
    }

    private boolean checkInput() {
        //TODO add limits/checks
        return true;
    }
}
