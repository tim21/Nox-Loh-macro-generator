package lohgen.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import lohgen.Consts;
import lohgen.gui.listeners.checkBoxListener;

public class RightTabbedPane extends JTabbedPane {

    public RightTabbedPane() {
        for (int cl = 0; cl < Consts.CLASSES.length; cl++) {
            addTab(Consts.CLASSES[cl], makeTab(cl));
        }
        setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        setBorder(BorderFactory.createTitledBorder(Consts.BORDER_ETCHEDLINE, "Heroes"));
    }

    private JPanel makeTab(int cl) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.ipadx = 0;
        c.ipady = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(1, 1, 1, 1);
        for (int hero = 0; hero < Consts.HERO_NAMES[cl].length; hero++) {
            c.gridx = hero % 6;
            c.gridy = hero / 6;
            panel.add(makeHeroBox(cl, hero), c);
        }
        return panel;
    }

    private JPanel makeHeroBox(int cl, int hero) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        String imagePath = "heroes/" + Consts.HERO_NAMES[cl][hero] + ".png";
        ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource(imagePath));
        JLabel imageLabel = new JLabel(image);
        imageLabel.setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
        imageLabel.setBorder(Consts.BORDER_BLACKLINE1);
        JCheckBox heroCheck = new JCheckBox(Consts.HERO_NAMES[cl][hero]);
        heroCheck.addActionListener(new checkBoxListener(cl, hero));
        heroCheck.setPreferredSize(new Dimension(image.getIconWidth(), 20));
        heroCheck.setHorizontalAlignment(SwingConstants.CENTER);
        heroCheck.setBorder(Consts.BORDER_BLACKLINE1);
        heroCheck.setBorderPainted(true);
        panel.add(imageLabel, BorderLayout.CENTER);
        panel.add(heroCheck, BorderLayout.SOUTH);
        panel.setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight() + 20));
        panel.setBorder(Consts.BORDER_BLACKLINE1);
        return panel;
    }
}
