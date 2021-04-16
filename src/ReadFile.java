import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ReadFile extends JFrame {

    private JTextField addressBar;
    private JEditorPane display;

    public ReadFile() {
        super("Web Browser");

        addressBar = new JTextField("url + Enter");
        addressBar.addActionListener(
                event -> load(event.getActionCommand())
        );
        add(addressBar, BorderLayout.NORTH);

        display = new JEditorPane();
        display.setEditable(false);
        display.addHyperlinkListener(
                event -> {
                    if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                        load(event.getURL().toString());
                    }
                }
        );
        add(new JScrollPane(display), BorderLayout.CENTER);
        setSize(800, 600);
        setVisible(true);
    }

    private void load(String userText) {
        try {
            display.setPage(userText);
            addressBar.setText(userText);
        } catch (Exception e) {
            System.out.println("errors in loading: " + e);
        }
    }

}


