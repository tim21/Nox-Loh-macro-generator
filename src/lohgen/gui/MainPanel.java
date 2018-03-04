package lohgen.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

    public MainPanel() {
        super(new BorderLayout());
        setBackground(Color.black);
        add(new LeftPanel(), BorderLayout.WEST);
        add(new RightPanel(), BorderLayout.EAST);
    }

}
