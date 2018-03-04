package lohgen.gui;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanel extends JPanel {

    public InfoPanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        String s1 = "this is string s1";
        String s2 = "this is string s2";
        String linkString = "http://google.com";
        JLabel label1 = new JLabel(s1);
        add(label1);
        JLabelLink link = new JLabelLink(linkString);
        add(link);
        JLabel label2 = new JLabel(s2);
        add(label2);
    }
}
