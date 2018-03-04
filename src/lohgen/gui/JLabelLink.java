package lohgen.gui;

import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

public class JLabelLink extends JLabel {

    private static final String A_HREF = "<a href=\"";
    private static final String HREF_CLOSED = "\">";
    private static final String HREF_END = "</a>";
    private static final String HTML = "<html>";
    private static final String HTML_END = "</html>";

    public JLabelLink(String text) {
        super(text);
        if (isBrowsingSupported()) {
            makeLinkable(new LinkMouseListener());
        }
    }

    private void makeLinkable(MouseListener ml) {
        assert ml != null;
        setText(htmlIfy(linkIfy(getText())));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addMouseListener(ml);
    }

    private static boolean isBrowsingSupported() {
        if (!Desktop.isDesktopSupported()) {
            return false;
        }
        boolean result = false;
        Desktop desktop = java.awt.Desktop.getDesktop();
        if (desktop.isSupported(Desktop.Action.BROWSE)) {
            result = true;
        }
        return result;
    }

    class LinkMouseListener extends MouseAdapter {

        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            try {
                JLabel l = (JLabel) evt.getSource();
                URI uri = new java.net.URI(JLabelLink.getPlainLink(l.getText()));
                (new LinkRunner(uri)).execute();
            } catch (URISyntaxException ex) {
                Logger.getLogger(JLabelLink.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static class LinkRunner extends SwingWorker<Void, Void> {

        private final URI uri;

        private LinkRunner(URI u) {
            if (u == null) {
                throw new NullPointerException();
            }
            uri = u;
        }

        @Override
        protected Void doInBackground() throws Exception {
            Desktop desktop = java.awt.Desktop.getDesktop();
            desktop.browse(uri);
            return null;
        }

        @Override
        protected void done() {
            try {
                get();
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(JLabelLink.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static String getPlainLink(String s) {
        return s.substring(s.indexOf(A_HREF) + A_HREF.length(), s.indexOf(HREF_CLOSED));
    }

    private static String linkIfy(String s) {
        return A_HREF.concat(s).concat(HREF_CLOSED).concat(s).concat(HREF_END);
    }

    private static String htmlIfy(String s) {
        return HTML.concat(s).concat(HTML_END);
    }
}
