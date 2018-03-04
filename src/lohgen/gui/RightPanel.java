package lohgen.gui;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class RightPanel extends JPanel {

    public RightPanel() {
        super(new BorderLayout());
        add(new RightTabbedPane(), BorderLayout.NORTH);
        add(new RightBottomPanel(), BorderLayout.SOUTH);
    }
}
