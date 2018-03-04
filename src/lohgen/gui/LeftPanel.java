package lohgen.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lohgen.Consts;

public class LeftPanel extends JPanel {

    public LeftPanel() {
        super(new BorderLayout());
        String imagePath = "selenegasm.png";        
        ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource(imagePath));
        JLabel imageLabel = new JLabel(image);
        imageLabel.setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
        imageLabel.setBorder(Consts.BORDER_BLACKLINE2);
        add(imageLabel, BorderLayout.NORTH);
        add(new InfoPanel(), BorderLayout.CENTER);
        setBorder(BorderFactory.createTitledBorder(Consts.BORDER_ETCHEDLINE, "Info"));
    }
}
