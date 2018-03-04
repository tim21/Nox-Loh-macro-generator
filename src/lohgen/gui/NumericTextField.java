package lohgen.gui;

import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class NumericTextField extends JTextField {

    NumericTextField(String s, int i) {
        super(s, i);
    }

    @Override
    protected Document createDefaultModel() {
        return new NumericDocument();
    }

    private static class NumericDocument extends PlainDocument {

        private final static Pattern DIGITS = Pattern.compile("\\d*");

        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (str != null && DIGITS.matcher(str).matches()) {
                super.insertString(offs, str, a);
            }
        }
    }
}
