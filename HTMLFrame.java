import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

class HTMLFrame
extends JFrame
implements HyperlinkListener {
    JEditorPane editorPane = new JEditorPane();
    JScrollPane scrollPane;

    public HTMLFrame(String string, boolean bl) {
        super("Cryptic Tool 1.0.0 -- By: Jackie, Bhavesh, Mansi, Amey ");
        this.editorPane.setEditable(false);
        if (bl) {
            this.editorPane.setBackground(Color.white);
            this.setTitle("Cryptic Tool 1.0.0 -- By: Jackie, Bhavesh, Mansi, Amey");
        }
        this.editorPane.addHyperlinkListener(this);
        this.scrollPane = new JScrollPane(this.editorPane);
        try {
            this.editorPane.setPage(string);
            this.getContentPane().add(this.scrollPane);
        }
        catch (Exception var3_3) {
            JOptionPane.showMessageDialog(this, "Oops!! Error\n" + var3_3, "Error", 2);
            return;
        }
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(dimension.width, dimension.height);
        this.setVisible(true);
    }

    @Override
    public void hyperlinkUpdate(HyperlinkEvent hyperlinkEvent) {
        if (hyperlinkEvent.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            try {
                this.editorPane.setPage(hyperlinkEvent.getURL());
            }
            catch (Exception var2_2) {
                JOptionPane.showMessageDialog(this, "Oops!! Error\n" + var2_2, "Error", 2);
            }
        }
    }
}