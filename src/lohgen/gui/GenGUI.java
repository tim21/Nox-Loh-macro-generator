package lohgen.gui;

import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import lohgen.Consts;

public class GenGUI extends JFrame {

    public GenGUI() {
        super(Consts.NAME + " " + Consts.VERSION);
        setResizable(false);
        String imagePath = "icon.png";
        Image image = (new ImageIcon(getClass().getClassLoader().getResource(imagePath))).getImage();
        this.setIconImage(image);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new MainPanel(), BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
//        try {
//            try (BufferedWriter writer = new BufferedWriter(new FileWriter("tmp.txt"))) {
//                writer.write("yolo");
//            }
//            SevenZUtils.compress("zip.7z", new File("tmp.txt"));
//        } catch (IOException ex) {
//            Logger.getLogger(GenGUI.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
